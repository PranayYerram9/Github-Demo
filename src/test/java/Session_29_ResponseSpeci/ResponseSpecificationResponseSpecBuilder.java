package Session_29_ResponseSpeci;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationResponseSpecBuilder {
	
	ResponseSpecification responsespec;
	
	@Test
	public void testA() {
		
		ResponseSpecBuilder responsebuilder=new ResponseSpecBuilder();
		responsebuilder.expectStatusCode(200);
		responsebuilder.expectStatusLine("HTTP/1.1 200 OK");
		responsebuilder.expectContentType("application/json");
//		responsebuilder.expectResponseTime(Matchers.lessThan(3000L));
		
		responsespec=responsebuilder.build();
		
		RestAssured.given()
				.baseUri("https://reqres.in/api/users?page=2")
			.when()
				.get()
			.then()
				.spec(responsespec);
	}
	
	@Test
	public void testB() {
		RestAssured.given()
				.baseUri("https://reqres.in/api/users?page=2")
			.when()
				.get()
			.then()
				.statusCode(200)
				.contentType("application/json");
	}
	
}
