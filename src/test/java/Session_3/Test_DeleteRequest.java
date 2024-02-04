package Session_3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_DeleteRequest {
	
	@Test
	public void deletetest() {
		RestAssured.baseURI="https://reqres.in/api/users/479";
		
		RestAssured.given().when().delete().then().statusCode(204);
	}
	
}
