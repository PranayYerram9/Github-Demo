package Session_12_SerialAndDeserial;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Deserialization {
	
	@Test
	public void Deserial() throws JsonMappingException, JsonProcessingException {
		RequestSpecification ReqSpec=RestAssured.given();
		
		JSONObject data=new JSONObject();
		data.put("name", "pranay");
		data.put("job", "Tester");
		
		ReqSpec.baseUri("https://reqres.in/api/users");
		
		ReqSpec.contentType(ContentType.JSON).body(data.toString());
		Response res=ReqSpec.post();
		
		System.out.println(res.body().asPrettyString());
		POJOTestData pojodata=res.body().as(POJOTestData.class);
		
		ObjectMapper mapper=new ObjectMapper();
		POJOTestData pojodata1=mapper.readValue(res.asString(), POJOTestData.class);
		
		System.out.println(pojodata.id);
		System.out.println(pojodata1.createdAt);
	}
}
