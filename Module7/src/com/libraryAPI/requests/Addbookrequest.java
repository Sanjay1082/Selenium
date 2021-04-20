package com.libraryAPI.requests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.librarypayload.DataandReuseableOperations.Librarypayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class Addbookrequest {
	
	@Test(dataProvider="getBooksDetail")
	public void AddBook(String isbn, String aisle)
	{
		
		RestAssured.baseURI="http://216.10.245.166";
		
		String response1 = given().log().all().header("Content-Type", "application/json").body(Librarypayload.AddLib(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println();
		System.out.println();
		System.out.println(response1);
		
		
		JsonPath js =Librarypayload.getParseresponse(response1);
		
      String id = js.getString("ID");
      
      System.out.println(id);
		
	}
	
	
	
	@Test(dataProvider="getBooksDetail")
	public void DeleteBook(String isbn, String aisle) throws IOException
	{

		RestAssured.baseURI="http://216.10.245.166";
		
		given().log().all().header("Content-Type","application/json").body(Librarypayload.deletebook(isbn, aisle))
		.when().delete("/Library/DeleteBook.php")
		.then().log().all().assertThat().statusCode(200);
	}
	
	/*
	@Test(dataProvider="getBooksDetail")
	public void DeleteBook() throws IOException
	{

		RestAssured.baseURI="http://216.10.245.166";
		
		given().log().all().header("Content-Type","application/json")//.body(Librarypayload.deletebook(aisle, isbn))
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\M1056369\\Desktop\\RestAssured\\DeletePayload.txt"))))
		.when().delete("/Library/DeleteBook.php")
		.then().log().all().assertThat().statusCode(200);
	}
	*/
	
	@DataProvider
	public Object[][] getBooksDetail()
	{
		return new Object[][]{{"abc","123"},{"bcd","234"},{"cde","345"},{"def","345"},{"efg","456"}};
	}

}
