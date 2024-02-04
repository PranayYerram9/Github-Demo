package Session_7_QueryPathParams;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo {
	
	@Test
	public void test() {
		
		RequestSpecification ReqSpec=RestAssured.given();
		ReqSpec.baseUri("https://reqres.in/api");
		ReqSpec.basePath("{usersPath}");
		ReqSpec.pathParam("usersPath","users");
		ReqSpec.queryParams("page",1);
		ReqSpec.queryParam("id", 6);
		
		
		Response res=ReqSpec.get();
		
		System.out.println(res.asString());
		
		JsonPath jsonpath=res.jsonPath();
		System.out.println(jsonpath.get("data.last_name").toString());
		
	}
	
}
