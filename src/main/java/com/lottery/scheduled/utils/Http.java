package com.lottery.scheduled.utils;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

@Component
public class Http {
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	public String get(String url){
		String responsedata = null;
		OkHttpClient client = new OkHttpClient();
		try {
			Request request = new Request.Builder().url(url).build();
			Response response = client.newCall(request).execute();
			responsedata = response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responsedata;
	}

	public String postJson(String url, String json){
		String responsedata = null;
		OkHttpClient client = new OkHttpClient();
		RequestBody body = RequestBody.create(JSON, json);
		try {
			Request request = new Request.Builder().url(url).post(body).build();
			Response response = client.newCall(request).execute();
			responsedata = response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responsedata;
	}

	public String postForm(String url, RequestBody formBody){
		String responsedata = null;
		OkHttpClient client = new OkHttpClient();
		try {
			Request request = new Request.Builder().url(url).post(formBody).build();
			Response response = client.newCall(request).execute();
			if (!response.isSuccessful())  throw new IOException("Unexpected code " + response);
			responsedata = response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responsedata;
	}
}
