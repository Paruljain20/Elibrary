package com.app.elib.paypal.rest;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.elib.paypal.config.PaypalConfig;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import com.sun.jersey.core.util.Base64;

public class PaypalRestService {
	
	private final static String TOKEN_URL = "/v1/oauth2/token";
	
	private String authEndpoint = "https://api.sandbox.paypal.com";
	
	@Autowired
	private PaypalConfig paypalConfig;
	
	public HttpResponse<String> login(){
		  String url = "https://api.sandbox.paypal.com/v1/oauth2/token";
	        String name = "AQ6KiepBQ1YTP9EBehCwiE38xylZwVaIhp8Q60UYy8VYgs_DQnY4Dy8uFpYQ2wZabEk6ILWKWWcYt-tY";
	        String password = "EIQ8DW2xw91kmN8gOgYlcxSzJmhb-JVy8vZN7sVCfmOdgPYbQiwygxTrXP0NruJ68_N1fYXTWYZjXDKB";
	        String authString = name + ":" + password;
	        Base64 base64 = new Base64();
	        String encodedString = new String(base64.encode(authString.getBytes()));
	        System.out.println("Base64 encoded auth string: " + encodedString);
	        HttpRequest request = Unirest.post(url)
	        		.header("Authorization", "Basic " + encodedString)
	        		.header("Accept", "application/json")
	        		.header("Content-Type", "application/x-www-form-urlencoded")
	        		.header("Access-Control-Allow-Origin", "http://localhost:8080/Elibrary")
	        		.body("grant_type=client_credentials")
	        		.getHttpRequest();
            HttpResponse<String> response;
			try {
				response = execute(request);
				 if(response.getStatus() == 200){
					 return response;
			        }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
	 private HttpResponse<String> execute(HttpRequest request) throws UnirestException {
	        return request.asString();
	    }
}
