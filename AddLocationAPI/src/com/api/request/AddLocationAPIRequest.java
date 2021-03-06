package com.api.request;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import com.api.data.AddRequestData;
import com.api.data.UpdateLocationData;

public class AddLocationAPIRequest {
	
	public static String placeid;
	public static String response;
	

public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
	   //Post request on address endpoint
		
		response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(AddRequestData.getdata())
	    .when().post("/maps/api/place/add/json")
	    .then()
	    //.log().all()
	    .assertThat()
	    .statusCode(200).body("scope", equalTo("APP")).extract().asString();
	    
	    System.out.println(response);
	    
	    
		   //Post request on address endpoint
	   
	    given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(AddRequestData.getdata())
	    	    .when().post("/maps/api/place/add/json")
	    	    .then()
	    	    .log().all()
	    	    .assertThat()
	    	    .statusCode(200).body("scope", equalTo("APP")).body("status", equalTo("OK"))
	    	    .header("Server", "Apache/2.4.18 (Ubuntu)");
	    
	    JsonPath js =new JsonPath(response);
	    placeid = js.get("place_id");
	    System.out.println(placeid);
	    System.out.println();
	    System.out.println();
	    
	    
		   //Get request on address endpoint
	    
	    given().log().all().queryParam("place_id", placeid).queryParam("key", "qaclick123")
	    .when().get("/maps/api/place/get/json")
	    .then()
	      .log().all().statusCode(200)
	         .assertThat()
	             .body("name", equalTo("Frontline house"))
	             .body("phone_number", equalTo("(+91) 983 893 3937"))
	             .body("address", equalTo("29, side layout, cohen 09"))
	             .body("language", equalTo("French-IN"))
	                  .header("Server", "Apache/2.4.18 (Ubuntu)");
	    
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    
	    
	    
		   //Put request on address endpoint
	    
	    given().log().all().queryParam("place_id", placeid).queryParam("key", "qaclick123").body(UpdateLocationData.getdata())
	    .when().put("/maps/api/place/update/json")
	    .then().log().all().statusCode(200);
	    
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    
	    //Get request on address endpoint
	    
	    given().log().all().queryParam("place_id", placeid).queryParam("key", "qaclick123")
	    .when().get("/maps/api/place/get/json")
	    .then().log().all().statusCode(200)
	        .assertThat()
	           .body("name", equalTo("Frontline house"))
	           .body("phone_number", equalTo("(+91) 983 893 3937"));
	

	    System.out.println();
	    System.out.println();
	    System.out.println();
	    
	    
	    given().log().all().queryParam("key", "qaclick123")
	    .body("{\r\n" + 
	    		"    \"place_id\":\""+placeid+"\"\r\n" + 
	    		"}\r\n" + 
	    		"")
	    .when().delete("/maps/api/place/delete/json")
	    .then().log().all().statusCode(200);
}
}
