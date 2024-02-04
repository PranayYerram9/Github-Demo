package Session_30_JSONSchemaValidation;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

public class SchemaValidation {
	
	@Test
	public void jsonSchemaValidation() {
		
		JSONObject data=new JSONObject();
		data.put("username", "admin");
		data.put("password", "password123");
		
		RequestSpecification reqspec=RestAssured.given();
		
		reqspec.baseUri("https://restful-booker.herokuapp.com/auth");
		reqspec.contentType("application/json");
		reqspec.body(data.toJSONString());
		
		Response res=reqspec.post();
		assertEquals(res.statusCode(), 200);
		res.then().body(JsonSchemaValidator.matchesJsonSchema(new File("D:\\Pranay\\Personal\\Learning\\eclipse-workspace\\CodeStudioRestAssured\\schema.json")));
		System.out.println(res.body().asPrettyString());
		JsonSchemaValidator.matchesJsonSchema("{\r\n"
				+ "	\"type\":\"object\",\r\n"
				+ "    \"required\":[\"token\"],\r\n"
				+ "    \"properties\":{\r\n"
				+ "     	 \"token\":{\r\n"
				+ "          	\"type\":\"string\" \r\n"
				+ "         }\r\n"
				+ "    }\r\n"
				+ "}");
		
	}
	
	
	
	
	
	
}
