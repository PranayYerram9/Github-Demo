package Session_24_ExcludeDataPayload;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExcludeNullDefaultEmptyValuesInPayload {

	@Test
	public void testA() throws JsonProcessingException {
		pojoData testdata = new pojoData();
//		testdata.setLastname("Yerram");
		testdata.setFirstname("Pranay");
//		testdata.setAge(23);
		testdata.setSalary(10000.67f);
		testdata.setMarried(true);
		
		String[] hob=new String[2];
		hob[0]="Reading";
		hob[1]="Games";
		testdata.setHobbies(hob);
		
		Map add=new HashMap();
		add.put("City", "Hyderabad");
		add.put("Pincode", 203333);
//		testdata.setAddress(add);

		System.out.println(testdata.toString());
		
		ObjectMapper mapper=new ObjectMapper();
		String userdata=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(testdata);
		System.out.println(userdata);

	}

}
