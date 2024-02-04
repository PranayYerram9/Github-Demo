package Session_6_ResponseBodyValidation;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ResponseValidate {
	
	@Test
	public void testA() {
		RequestSpecification ReqSpec=RestAssured.given();
		ReqSpec.baseUri("https://reqres.in/");
		ReqSpec.basePath("api/users?page=2");
		
		Response res=ReqSpec.get();
		
		ResponseBody ResBody=res.body();
		
		String response=ResBody.asString();
		System.out.println(response);
		assertEquals(response.contains("Janet"), true);
		
		JsonPath jsonpath=ResBody.jsonPath();
		System.out.println(jsonpath.get("data[1].avatar").toString());
		
	}
}
