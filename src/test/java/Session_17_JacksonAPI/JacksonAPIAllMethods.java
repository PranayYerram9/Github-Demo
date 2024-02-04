package Session_17_JacksonAPI;

import java.util.Iterator;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonAPIAllMethods {
	
	@Test
	public void testA() throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		
		ObjectNode dataNode=mapper.createObjectNode();
		dataNode.put("firstname", "Pranay");
		dataNode.put("Lastname", "Yerram");
		dataNode.put("Salary", 12000.67);
		
		ObjectNode techskills=mapper.createObjectNode();
		techskills.put("Programming Skills", "Java");
		techskills.put("Web Automation", "Selenium");
		techskills.put("API automation", "Rest Assured");
		
		dataNode.set("TechSkills", techskills);
		
		String data=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataNode);
		System.out.println("created Node: "+data);
		
		//Checking all field details
		
		Iterator <String> fielddetails=dataNode.fieldNames();
		while(fielddetails.hasNext()) {
			System.out.println(fielddetails.next());
		}
		
		Iterator<JsonNode> valuedetails=dataNode.elements();
		while(valuedetails.hasNext()) {
			System.out.println(valuedetails.next());
		}
		
//		Iterator<Entry> allValues=dataNode.fields();
//		while(allValues.hasNext()) {
//			Entry val=allValues.next();
//			
//			System.out.println(val.getKey()+" : "+val.getValue());
//		}
		
		
		//Update Data
		
		dataNode.put("Lastname", "Kethi");
		techskills.put("Programming Skills", "Python");
		dataNode.set("TechSkills", techskills);
		
		System.out.println(dataNode);
		
		//Delete Data
		
		dataNode.remove("Salary");
		System.out.println(dataNode.toPrettyString());
		
		
	}
	
}
