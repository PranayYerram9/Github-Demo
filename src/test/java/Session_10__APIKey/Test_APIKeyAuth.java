package Session_10__APIKey;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//NOT WORKING

public class Test_APIKeyAuth {
	
	@Test
	public void testAPIKey() {
		RequestSpecification ReqSpec = RestAssured.given();
		
		ReqSpec.baseUri("https://home.openweathermap.org");
		ReqSpec.basePath("/data/2.5/weather");
		ReqSpec.queryParam("q","hyderabad");
		ReqSpec.queryParam("appid","aadae3fc9063b54a7e8b51f7360ab3ee");
		
		Response res=ReqSpec.get();
		
		assertEquals(res.statusCode(), 200);
	}
	
}	
