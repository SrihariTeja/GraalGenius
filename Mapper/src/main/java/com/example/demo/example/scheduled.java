package com.example.demo.example;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class scheduled {
	
	@Autowired static JavaScriptInJava js;
	
	@Scheduled(cron=" 0 */10 * * * *")
	public static void just() {
		System.out.println("This is a scheduler");
		System.out.println("The current time is::"+new Date());
		try {
			 String s = "{\r\n"
	    		 		+ "  \"name\": \"John Doe\",\r\n"
	    		 		+ "  \"age\": 30,\r\n"
	    		 		+ "  \"email\": \"john.doe@example.com\",\r\n"
	    		 		+ "  \"address\": {\r\n"
	    		 		+ "    \"street\": \"123 Main St\",\r\n"
	    		 		+ "    \"city\": \"Springfield\",\r\n"
	    		 		+ "    \"state\": \"IL\",\r\n"
	    		 		+ "    \"zip\": \"62701\"\r\n"
	    		 		+ "  },\r\n"
	    		 		+ "  \"isActive\": true,\r\n"
	    		 		+ "  \"hobbies\": [\"reading\", \"traveling\", \"coding\"]\r\n"
	    		 		+ "}\r\n"
	    		 		+ "";
			 String s1 = ";var name = source.name;console.log(name)";
			js.testJS(s,s1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
