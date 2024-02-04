package Session_2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleGetRequest {
	
	@Test
	void getreq() {
		Response res=RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.asString());
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getBody());
		System.out.println(res.getHeaders());
		System.out.println(res.detailedCookies());
	}
}
