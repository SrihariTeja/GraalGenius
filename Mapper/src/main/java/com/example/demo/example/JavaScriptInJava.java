package com.example.demo.example;

import org.graalvm.polyglot.Context;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class JavaScriptInJava {

    public static void testJS(String request,String name) {
    	 try (Context context = Context.create()) {
    		
    		 JSONObject js = new JSONObject(request);
    		 String sour = " var source ="+js;
    		 sour = sour+name;
    		
    				 
    		 
            // String script = "for (var i = 1; i <= 10; i++) { print('This is line ' + i); }";
             context.eval("js", sour);  // Using GraalVM's JS engine
         } catch (Exception e) {
             e.printStackTrace();
         }

    }
}
