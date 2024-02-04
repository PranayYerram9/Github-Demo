package Session_18Fileupload;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FileUpload {
	
	@Test
	public void uploadFile() {
		File upload=new File("C:\\Users\\User\\Desktop\\New Text Document.txt");
		File upload2=new File("C:\\Users\\User\\Desktop\\New Text Document.txt");
		
		RequestSpecification reqspec = RestAssured.given();
		
		reqspec.baseUri("http://httpbin.org/post");
		reqspec.multiPart("files",upload);
		reqspec.multiPart("files",upload2);
		reqspec.contentType("multipart/form-data");
		
		Response res=reqspec.post();
		
		assertEquals(res.statusCode(), 200);
		System.out.println(res.prettyPrint());
		
	}
	
}
