package com.generic;



import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class get_operation {
	
	
	public static void getTest() {
		
		
Response response = RestAssured.get("https://httpbin.org/get");		
		
		
		
	response.prettyPrint();
	
	System.out.println(response.statusCode());
	
	Assert.assertEquals(response.statusCode(), 200);
	
	SoftAssert sf = new SoftAssert();
	 sf.assertEquals(response.statusCode(), 200);
	sf.assertAll();
	
	} 






}
