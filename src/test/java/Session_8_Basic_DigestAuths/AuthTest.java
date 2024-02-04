package Session_8_Basic_DigestAuths;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthTest {
	
	@Test
	public void basicTest() {
		RestAssured.baseURI="https://httpbin.org/basic-auth/Pranay/Pranay";
		RequestSpecification ReqSpec=RestAssured.given();
		
		ReqSpec.auth().basic("Pranay", "Pranay");
//						OR
		ReqSpec.auth().preemptive().basic("Pranay", "Pranay");
		
		Response res=ReqSpec.get();
		
		assertEquals(res.statusCode(), 200);
		System.out.println(res.body().asString());
	}
	
	@Test
	public void digestTest() {
		RequestSpecification ReqSpec=RestAssured.given();
		
		ReqSpec.baseUri("https://httpbin.org/");
		ReqSpec.basePath("digest-auth/auth/Pranay/Pranay/SHA-256");
		
		ReqSpec.auth().digest("Pranay", "Pranay");
		
		Response res=ReqSpec.get();
		assertEquals(res.statusCode(), 200);
		System.out.println(res.body().asString());
		
	}
}
