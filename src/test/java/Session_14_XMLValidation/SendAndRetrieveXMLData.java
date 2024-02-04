package Session_14_XMLValidation;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SendAndRetrieveXMLData {
	
	@Test
	public void addPet() {
		String XMLData="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		
		RequestSpecification ReqSpec=RestAssured.given();
		
		ReqSpec.baseUri("https://petstore.swagger.io/v2/pet");
		ReqSpec.contentType("application/xml");
		ReqSpec.headers("accpet","application/xml");
		ReqSpec.body(XMLData);
		
		Response res=ReqSpec.post();
		
		System.out.println(res.asPrettyString());
		
		res.then().body("name", Matchers.equalTo("doggie"));	//hamercast validations
		
		
	}
	
	
	@Test
	public void getTravellerData() {
		String xmldata="<TravelerinformationResponse xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n"
				+ "  <page>1</page>\r\n"
				+ "  <per_page>10</per_page>\r\n"
				+ "  <totalrecord>36608</totalrecord>\r\n"
				+ "  <total_pages>3661</total_pages>\r\n"
				+ "  <travelers>\r\n"
				+ "    <Travelerinformation>\r\n"
				+ "      <id>11133</id>\r\n"
				+ "      <name>Developer</name>\r\n"
				+ "      <email>Developer12@gmail.com</email>\r\n"
				+ "      <adderes>USA</adderes>\r\n"
				+ "      <createdat>0001-01-01T00:00:00</createdat>\r\n"
				+ "    </Travelerinformation>\r\n"
				+ "    <Travelerinformation>\r\n"
				+ "      <id>11134</id>\r\n"
				+ "      <name>AS</name>\r\n"
				+ "      <email>qweqw@mail.ru</email>\r\n"
				+ "      <adderes>USA</adderes>\r\n"
				+ "      <createdat>0001-01-01T00:00:00</createdat>\r\n"
				+ "    </Travelerinformation>\r\n"
				+ "    <Travelerinformation>\r\n"
				+ "      <id>11135</id>\r\n"
				+ "      <name>vano</name>\r\n"
				+ "      <email>van.19v@mail.ru</email>\r\n"
				+ "      <adderes>USA</adderes>\r\n"
				+ "      <createdat>0001-01-01T00:00:00</createdat>\r\n"
				+ "    </Travelerinformation>\r\n"
				+ "    <Travelerinformation>\r\n"
				+ "      <id>11136</id>\r\n"
				+ "      <name>Developer123</name>\r\n"
				+ "      <email>Developer523@gmail.com</email>\r\n"
				+ "      <adderes>USA</adderes>\r\n"
				+ "      <createdat>0001-01-01T00:00:00</createdat>\r\n"
				+ "    </Travelerinformation>\r\n"
				+ "    <Travelerinformation>\r\n"
				+ "      <id>11137</id>\r\n"
				+ "      <name>Ashor</name>\r\n"
				+ "      <email>ashot.vardanyan.2000@gmail.com</email>\r\n"
				+ "      <adderes>USA</adderes>\r\n"
				+ "      <createdat>0001-01-01T00:00:00</createdat>\r\n"
				+ "    </Travelerinformation>\r\n"
				+ "    <Travelerinformation>\r\n"
				+ "      <id>11138</id>\r\n"
				+ "      <name>1234</name>\r\n"
				+ "      <email>ghag@mail.ru</email>\r\n"
				+ "      <adderes>USA</adderes>\r\n"
				+ "      <createdat>0001-01-01T00:00:00</createdat>\r\n"
				+ "    </Travelerinformation>\r\n"
				+ "    <Travelerinformation>\r\n"
				+ "      <id>11139</id>\r\n"
				+ "      <name>asdasd</name>\r\n"
				+ "      <email>asdasd@dasda.asd</email>\r\n"
				+ "      <adderes>USA</adderes>\r\n"
				+ "      <createdat>0001-01-01T00:00:00</createdat>\r\n"
				+ "    </Travelerinformation>\r\n"
				+ "    <Travelerinformation>\r\n"
				+ "      <id>11140</id>\r\n"
				+ "      <name>da</name>\r\n"
				+ "      <email>auriu@gmail.com</email>\r\n"
				+ "      <adderes>USA</adderes>\r\n"
				+ "      <createdat>0001-01-01T00:00:00</createdat>\r\n"
				+ "    </Travelerinformation>\r\n"
				+ "    <Travelerinformation>\r\n"
				+ "      <id>11142</id>\r\n"
				+ "      <name>asdasd</name>\r\n"
				+ "      <email>qwwerrwerweeqw@mail.ru</email>\r\n"
				+ "      <adderes>USA</adderes>\r\n"
				+ "      <createdat>0001-01-01T00:00:00</createdat>\r\n"
				+ "    </Travelerinformation>\r\n"
				+ "    <Travelerinformation>\r\n"
				+ "      <id>11143</id>\r\n"
				+ "      <name>karen</name>\r\n"
				+ "      <email>karen@mail.ru</email>\r\n"
				+ "      <adderes>USA</adderes>\r\n"
				+ "      <createdat>0001-01-01T00:00:00</createdat>\r\n"
				+ "    </Travelerinformation>\r\n"
				+ "  </travelers>\r\n"
				+ "</TravelerinformationResponse>";
		
		RequestSpecification ReqSpec=RestAssured.given();
		
		ReqSpec.baseUri("http://restapi.adequateshop.com/api/Traveler");
		ReqSpec.queryParam("page",5);
		
		Response res=ReqSpec.get();
		
//		System.out.println(res.asPrettyString());
		
		XmlPath xmlpath=new XmlPath(res.asString());
		System.out.println(xmlpath.get("TravelerinformationResponse.travelers.Travelerinformation[3].name").toString());
		
		List<String> AllTravellers=xmlpath.getList("TravelerinformationResponse.travelers.Travelerinformation");
		System.out.println(AllTravellers.size());
		
	}
}
