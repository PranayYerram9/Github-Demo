package Session_28_headers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

public class SendHeaders {
	
	
	@Test
	public void testA() {
		
		RequestSpecification reqspec=RestAssured.given();
		
		reqspec.baseUri("https://reqres.in/api/users?page=2");
		
		//1: Method
		reqspec.header("Header1", "Value1");
		
		//2: Method
		Header header=new Header("Header2","Value2");
		reqspec.header(header);
		
		//3: Method
		Map headermap=new HashMap();
		headermap.put("Header3", "Value3");
		headermap.put("Header4", "Value4");
		reqspec.headers(headermap);
		
		//4: Method
		List headerlist=new ArrayList();
		Header header1=new Header("Header5","Value5");
		Header header2=new Header("Header6","Value6");
		headerlist.add(header1);
		headerlist.add(header2);
		Headers headers=new Headers(headerlist);
		reqspec.headers(headers);
		
		reqspec.log().headers();
		reqspec.get();
		
	}
	
	
}
