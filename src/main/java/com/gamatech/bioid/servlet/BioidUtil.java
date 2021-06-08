package com.gamatech.bioid.servlet;

import java.io.IOException;

import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class BioidUtil {
	
	  // TODO: fill in your BWS Application-ID and -secret:
	private static String APP_ID = "2487b6a3-1870-440d-960b-d11b446fc0e1";
	private static String APP_SECRET = "gbzzo+5BCj2wC3Hnk0MkHTRV";
	private static String ENDPOINT = "https://bws.bioid.com/extension/";
	private static String STORAGE = "bws";
	private static int PARTITION = 11920;
	
	
	public static String getToken(int classid) throws IOException {

		// using OkHttpClient from the OkHttp library
		HttpUrl url = HttpUrl.parse(ENDPOINT + "token").newBuilder()
		        .addQueryParameter("id", APP_ID)
		        .addQueryParameter("bcid", STORAGE + "." + PARTITION + "." + classid)
		        .build();
		Request request = new Request.Builder()
		        .url(url)
		        .addHeader("Authorization", Credentials.basic(APP_ID, APP_SECRET))
		        .build();
		OkHttpClient client = new OkHttpClient();
		Response response = client.newCall(request).execute();
		String token = response.body().string();
		if (response.code() == 200) {
		    System.out.println("token=" + token);
		}
		return token;
	}

}
