package com.example.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/emp")
@RestController
public class EmployeeUpdateController {

	@GetMapping("/json")
	public void getEmp() {
		String s1 = "{\"employee\":{\"name\":\"sonoo\",\"salary\":56000,\"married\":true}}";
		JSONObject obj1 = new JSONObject(s1);
		JSONObject obj2 = obj1.getJSONObject("employee");
		obj2.getString("name");
		obj2.getInt("salary");
		obj2.getBoolean("married");
		System.out.println(obj2);
	}

	@PutMapping("/json")
	public void updateEmp() {
		String s1 = "{\"employee\":{\"name\":\"sonoo\",\"salary\":56000,\"married\":true}}";
		JSONObject obj1 = new JSONObject(s1);
		System.out.println("Json :" + obj1.toString());
		JSONObject obj2 = obj1.getJSONObject("employee");
		if (obj2.getString("name").equalsIgnoreCase("sonoo")) {
			obj2.put("name", "Raj");
		}
		System.out.println("Final Json :" + obj1.toString());
	}

	@GetMapping("/json1")
	public void getEmp1() {
		String s2 = "{\"employees\":[{\"name\":\"Shyam\", \"email\":\"shyamjaiswal@gmail.com\"},{\"name\":\"Bob\", \"email\":\"bob32@gmail.com\"},{\"name\":\"Jai\",\"email\":\"jai87@gmail.com\"}]}";
		JSONObject obj1 = new JSONObject(s2);
		JSONArray obj2 = obj1.getJSONArray("employees");
		/*Iterator<Object> it = obj2.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}*/
		for (int i = 0; i < obj2.length(); i++) {
			JSONObject obj3 = obj2.getJSONObject(i);
			obj3.getString("name");
			obj3.getString("email");
			System.out.println(obj3);
		}
	}
 
	// check 
	@PutMapping("/json1")
	public void updateEmp1() {
		String s2 = "{\"employees\":[{\"name\":\"Shyam\", \"email\":\"shyamjaiswal@gmail.com\"},{\"name\":\"Bob\", \"email\":\"bob32@gmail.com\"},{\"name\":\"Jai\",\"email\":\"jai87@gmail.com\"}]}";
		JSONObject obj1 = new JSONObject(s2);
		System.out.println("Before Json :" + obj1.toString());
		JSONArray obj2 = obj1.getJSONArray("employees");
		for (int i = 0; i < obj2.length(); i++) {
			JSONObject obj3 = obj2.getJSONObject(i);
			obj3.getString("name");
			obj3.getString("email");
			if (obj3.getString("name").equalsIgnoreCase("shyam"))
				obj3.put("name", "ashish");
			else if (obj3.getString("name").equalsIgnoreCase("shyam"))
				obj3.put("email1", "ashish4787@gmail.com");
		}
		System.out.println("Final Json :" + obj1.toString());
	}

	@GetMapping("/json2")
	public void getJsonOperation() {
		String s1 = "{\"organisation\":{\"employees\":[{\"name\":\"Shyam\",\"email\":\"shyamjaiswal@gmail.com\"},{\"name\":\"Bob\",\"email\":\"bob32@gmail.com\"},{\"name\":\"Jai\",\"email\":\"jai87@gmail.com\"}]}}";
		JSONObject obj1= new JSONObject(s1);
		JSONObject obj2= obj1.getJSONObject("organisation");
		JSONArray  obj3= obj2.getJSONArray("employees");
		 for(int i=0;i<obj3.length();i++) {
			 JSONObject obj4= obj3.getJSONObject(i);
			 obj4.getString("name");
			 obj4.getString("email");
		 }
		 System.out.println("Json "+obj3.toString());
	}
	
	
	@PutMapping("/json2")
	public void updateJsonOperation() {
		String s1 = "{\"organisation\":{\"employees\":[{\"name\":\"Shyam\",\"email\":\"shyamjaiswal@gmail.com\"},{\"name\":\"Bob\",\"email\":\"bob32@gmail.com\"},{\"name\":\"Jai\",\"email\":\"jai87@gmail.com\"}]}}";
		JSONObject obj1 = new JSONObject(s1);
		System.out.println("Json :" + obj1.toString());
		JSONObject obj2 = obj1.getJSONObject("organisation");
		JSONArray obj3 = obj2.getJSONArray("employees");

		for (int i = 0; i < obj3.length(); i++) {
			JSONObject obj4 = obj3.getJSONObject(i);
			obj4.getString("name");
			obj4.getString("email");
			if (obj4.getString("name").equalsIgnoreCase("shyam")) {
				obj4.put("email", "rai802212@gmail.com");
			}
		}
		System.out.println("Final Json :" + obj1.toString());

	}
}
