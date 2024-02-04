package Session_12_SerialAndDeserial;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Serialization {
	
	@Test
	public void serialTest() throws JsonProcessingException {
		POJOTestData data=new POJOTestData();
		data.setJob("Teacher");
		data.setName("Jeevan");
		
		ObjectMapper mapper=new ObjectMapper();
		String str=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		
		RequestSpecification ReqSpec = RestAssured.given();
		
		ReqSpec.basePath("https://reqres.in/api/users");
		ReqSpec.contentType(ContentType.JSON).body(str);
		
		Response res=ReqSpec.post();
		
		System.out.println(res.body().asString());
	}
	
}
