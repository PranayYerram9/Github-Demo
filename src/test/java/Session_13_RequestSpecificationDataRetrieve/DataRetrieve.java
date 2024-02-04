package Session_13_RequestSpecificationDataRetrieve;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class DataRetrieve {
	
	@Test
	public void testA() {
		
		JSONObject jsondata=new JSONObject();
		jsondata.put("name", "Klinn Kara");
		jsondata.put("job", "Army");
		
		RequestSpecification ReqSpec=RestAssured.given();
		
		ReqSpec.baseUri("https://reqres.in/api/users");
		ReqSpec.contentType("application/json")
		.body(jsondata.toJSONString());
		
		QueryableRequestSpecification query=SpecificationQuerier.query(ReqSpec);
		
		System.out.println(query.getBasePath());
		System.out.println(query.getBaseUri());
		System.out.println(query.getContentType());
		System.out.println(query.getCookies());
		System.out.println(query.getHeaders());
		System.out.println(query.getBody().toString());
		
		
	}
	
}
