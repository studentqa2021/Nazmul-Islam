package com.generic.crud.functions;

import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import openj9.internal.tools.attach.target.Response;

public class getfunction {
	
	
	public void getTest() {
 io.restassured.response.Response response	= RestAssured.get("http://dummy.restapiexample.com/api/v1/employees"); 
		
	System.out.println("Status code="response.statusCode());
	
	SoftAssert sa= new SoftAssert(;)
	
	}

}
