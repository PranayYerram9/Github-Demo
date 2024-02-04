package Session_4_ValidateResponsecodes;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TestStatusCodeLine {
	
	@Test
	public void testA() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		RequestSpecification RequestSpec = RestAssured.given();
		
		Response res = RequestSpec.get();
		
		assertEquals(res.statusCode(), 200);
		assertEquals(res.getStatusLine(), "HTTP/1.1 200 OK");
	}
	
	
	@Test
	public void testValidatableResponse() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		RequestSpecification requ=RestAssured.given();
		
		Response res=requ.get();
		
		ValidatableResponse validate=res.then();
		
		validate.statusCode(200);
		System.out.println("A");
		validate.statusLine("HTTP/1.1 200 OK");
	}
	
}
