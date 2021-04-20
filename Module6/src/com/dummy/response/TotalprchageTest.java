package com.dummy.response;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dummy.data.Dummyresponse;

import io.restassured.path.json.JsonPath;

public class TotalprchageTest {

	
	@Test
	public void totalPurchageTest()
	{
		String response = Dummyresponse.response;
		JsonPath js =Dummyresponse.getParseresponse(response);
		
		int numberofcousrse = js.getInt("courses.size()");
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		
		int sum =0;
		for(int i=0; i<numberofcousrse; i++)
		{
			
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			
			sum = sum + price*copies;
			
		}
		
		System.out.println("purchaseAmount is : "+purchaseAmount);
		
		System.out.println();
		
		System.out.println("Total sum is : "+sum);
		
		System.out.println();
		
		
		Assert.assertEquals(purchaseAmount, sum, "Both are the same, Assert is passing");
		
	}
}
