package Session_3;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PatchRequest {
	
	@Test
	public void patchtest() {
		JSONObject jsondata=new JSONObject();
		jsondata.put("name","john");
		
		RestAssured.baseURI="https://reqres.in/api/users/479";
		
		RestAssured.given().contentType(ContentType.JSON).body(jsondata.toJSONString())
		.when().patch()
		.then().statusCode(200).log().all();
	}
	
}
