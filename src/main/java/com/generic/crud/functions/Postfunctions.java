package com.generic.crud.functions;

import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Postfunctions {
	
	public void posttest() {
		JsonObject jo = new JsonObject();
		jo.addProperty("id", 999);
		jo.addProperty("employee_name", "Sarower");
		jo.addProperty("employee_salary", 5000);
		jo.addProperty("employee_age", 40);
		jo.addProperty("Job Title", "SDET");

		RequestSpecification rs = RestAssured.given();
		rs.body(jo.toString());
		rs.header("Content-Type","application/json");

		Response response= rs.post("http://dummy.restapiexample.com/api/v1/create");
		//response.prettyPrint();
		//Test cases & validation with assert
		
		//response status code P=200/F =400/500
		SoftAssert sa = new SoftAssert();
		
		int statuscode =response.statusCode();
		System.out.println(statuscode);
		sa.assertEquals(statuscode, 200);
		//response time (long same as int)
		long responseTime =response.time();
		System.out.println(responseTime);
		sa.assertTrue(responseTime <2000);
		
		//Data format Json or not
		String dataformat =response.contentType();
		System.out.println(dataformat);
		sa.assertTrue(dataformat.contains("json"));
		
		//Body 
			//Body = null or not null ****
		boolean bodyDataNotNull=!response.body().equals(null);// not null =true
		System.out.println(bodyDataNotNull);
		sa.assertTrue(bodyDataNotNull);
			// Body >> test data >> specific test data based on requirement ==> employee Name=Sarower
					// Rest Assured limitation = can not go inside json file ==> JsonPath
		JsonPath jp =response.jsonPath();
		System.out.println(jp.get("data.employee_name").toString());
		sa.assertEquals(jp.get("data.employee_name").toString(), "Sarower");
		
		//must do one thing for softassert
		sa.assertAll();//*****

	}
	
}