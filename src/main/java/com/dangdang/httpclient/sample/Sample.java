package com.dangdang.httpclient.sample;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sample {
	private static final Logger logger = LoggerFactory.getLogger(Sample.class);

	public static void main(String[] args) {

		CloseableHttpClient httpclient = HttpClients.createDefault();

		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();

		HttpGet httpget = new HttpGet("http://localhost:8080/springmvc-sample/hello");
		httpget.setConfig(requestConfig);

		
		try {
			CloseableHttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			logger.info("response is {}" ,response);
			logger.info("entity is {}" ,entity);
			logger.info("result is {}" ,EntityUtils.toString(entity));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//response.close();
		}

	}
}
