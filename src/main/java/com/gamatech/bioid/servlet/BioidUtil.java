package com.gamatech.bioid.servlet;

import java.io.IOException;
import java.util.Base64;
import java.nio.file.Files;
import java.io.File;

import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import org.json.*;

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
	
	public static void uploadAsync(String token, boolean isPeriocular, boolean isFace, String filePath) throws IOException {
		
		HttpUrl url;
		if (isPeriocular == true && isFace == true) {
			url = HttpUrl.parse(ENDPOINT + "upload").newBuilder()
					.addQueryParameter("trait", "face, periocular")
					.build();
		} else if (isPeriocular == true && isFace == false) {
			url = HttpUrl.parse(ENDPOINT + "upload").newBuilder()
					.addQueryParameter("trait", "periocular")
					.build();
		} else {
			url = HttpUrl.parse(ENDPOINT + "upload").newBuilder()
					.addQueryParameter("trait", "face")
					.build();
		}
		File image = new File(filePath);
		        
		Request request = new Request.Builder()
		        .url(url)
		        .addHeader("Authorization", "Bearer " + token)
		        .post(RequestBody.create(MediaType.parse("text/plain"), "data:image/png;base64," + Base64.getEncoder().encodeToString(Files.readAllBytes(image.toPath()))))
		        .build();
		OkHttpClient client = new OkHttpClient();
		Response response = client.newCall(request).execute();
		if (response.code() == 200) {
		    // using org.json.JSONObject from JSON-java library
		    JSONObject json = new JSONObject(response.body().string());
		    if (json.getBoolean("Accepted")) {
		        System.out.println("upload succeeded");
		    }
		}
	}

}
