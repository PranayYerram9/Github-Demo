package Session_15_HashMapSendData;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HashMapSendData {
	
	@Test
	public void testA() {
		
		HashMap testdata=new HashMap();
		testdata.put("Firstname", "Amod");
		testdata.put("Lastname", "Mahajan");
		testdata.put("Age", 28);
		testdata.put("Salary", 10000.89);
		testdata.put("IsMarried",false);
		
		List Hobbies=new ArrayList();
		Hobbies.add("Music");
		Hobbies.add("Computer");
		Hobbies.add("Games");
		
		HashMap techskills=new HashMap();
		techskills.put("Programming Language", "Java");
		techskills.put("Web Automation","Selenium");
		
		testdata.put("Hobbies", Hobbies);
		testdata.put("TechSkill",techskills);
		
		RequestSpecification reqspec=RestAssured.given();
		Response res=reqspec.baseUri("https://reqres.in/api/users").contentType("application/json").body(testdata).post();
		
		assertEquals(res.statusCode(), 201);
		System.out.println(res.asPrettyString());
	}
	
}
