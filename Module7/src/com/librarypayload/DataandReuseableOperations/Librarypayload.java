package com.librarypayload.DataandReuseableOperations;

import io.restassured.path.json.JsonPath;

public class Librarypayload {

	public static String AddLib(String isbn, String aisle)
	{
		String addbody = "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				"";
				
		return addbody;
	}
	
	public static String deletebook(String isbn, String aisle)
	{
		String id="{\r\n" + 
				" \r\n" + 
				"\"ID\" : \""+isbn+aisle+"\"\r\n" + 
				" \r\n" + 
				"} \r\n" + 
				"";
		return id;
	}
	
	
	public static JsonPath getParseresponse(String response)
	{
		JsonPath js =new JsonPath(response);
		return js;
		
	}
	
	
}
