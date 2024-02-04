package Session_5_ValidateHeaders;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_Headers {
	
	@Test
	public void test() {
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="api/users/2";
		
		RequestSpecification request=RestAssured.given();
		
		Response res=request.get();
		
		System.out.println(res.header("Connection"));
		assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		
		Headers header=res.getHeaders();
		for(Header head:header) {
			System.out.println(head.getName()+" : "+head.getValue());
		}
		
	}
}
