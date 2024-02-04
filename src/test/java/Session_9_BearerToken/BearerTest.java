package Session_9_BearerToken;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerTest {
	
	@Test
	public void testBearer() {
		RequestSpecification ReqSpec=RestAssured.given();
		
		JSONObject jsondata=new JSONObject();
		jsondata.put("Name", "Suresh Annamalai");
		jsondata.put("Age", 23);
		jsondata.put("Occupation", "Software Engineer");
		
		ReqSpec.baseUri("https://gorest.co.in/public/v2/users");
		
		ReqSpec.header("Authorization","Bearer af26a8d4c82e5aec72f34b9073251dc56899961710452a62788cafe4a239d467")
		.contentType(ContentType.JSON).body(jsondata.toString());
		
		Response res=ReqSpec.post();
		
		System.out.println(res.body().toString());
	}
}
