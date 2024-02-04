package Session_3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_GetRequest {
	
	@Test
	public void testget() {
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().queryParam("page", 2).when().get().then().statusCode(200);
	}
	
}
