package com.dangdang.okhttp.sample;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostExample {

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	public static final MediaType TEXT = MediaType.parse("text/html; charset=utf-8");
	
	private static final Logger logger = LoggerFactory.getLogger(PostExample.class);

	public static void main(String[] args) {
		String getUrl = "http://localhost:8080/springmvc-sample/hello";
		
		String postUrl = "http://localhost:8080/springmvc-sample/user";
		
		OkHttpClient client = new OkHttpClient();

		try {

			Request getRequest = new Request.Builder()
				      .url(getUrl)				      
				      .build();

			Response response = client.newCall(getRequest).execute();
			logger.info("response is {}",response.body().string());
			
			
			String json = "{\"name\":\"A\",\"age\":1}";
			RequestBody body = RequestBody.create(JSON, json);
			
			Request postRequest = new Request.Builder()
					            .url(postUrl)
					            .post(body)
					            .build();
			
			Response postResponse = client.newCall(postRequest).execute();
			logger.info("response is {}", postResponse.body().string());
		} catch (IOException e) {
			logger.error("", e);
		}

	}

}
