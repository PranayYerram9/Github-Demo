package Session_3;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_PostRequest {
	
	@Test
	public void posttest() {
		
		JSONObject jsondata=new JSONObject();
		jsondata.put("name", "Kavin");
		jsondata.put("job", "Tester");
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().header("Content-Type","application/json").body(jsondata.toString())
		.when().post()
		.then().statusCode(201).log().all();
		
	}
}
