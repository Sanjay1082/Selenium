package com.dummy.data;

import io.restassured.path.json.JsonPath;

public class Dummyresponse {
	
	
	public static String response ="{\r\n" + 
			"\"dashboard\": {\r\n" + 
			"\"purchaseAmount\": 910,\r\n" + 
			"\"website\": \"rahulshettyacademy.com\"\r\n" + 
			"},\r\n" + 
			"\"courses\": [\r\n" + 
			"{\r\n" + 
			"\"title\": \"Selenium Python\",\r\n" + 
			"\"price\": 50,\r\n" + 
			"\"copies\": 6\r\n" + 
			"},\r\n" + 
			"{\r\n" + 
			"\"title\": \"Cypress\",\r\n" + 
			"\"price\": 40,\r\n" + 
			"\"copies\": 4\r\n" + 
			"},\r\n" + 
			"{\r\n" + 
			"\"title\": \"RPA\",\r\n" + 
			"\"price\": 45,\r\n" + 
			"\"copies\": 10\r\n" + 
			"}\r\n" + 
			"]\r\n" + 
			"}";

	public static JsonPath getParseresponse(String response)
	{
		JsonPath js =new JsonPath(response);
		return js;
		
	}

}
