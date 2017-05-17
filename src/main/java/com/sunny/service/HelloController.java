package com.sunny.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {
	 /*
	  * http://localhost:8080/springMVC 使用的hello2.jsp
	  */
	 @RequestMapping("")
	   public String fun3(ModelMap model) {
	      model.addAttribute("message", "Hello pan");
	      return "hello2";
	   }
	 @RequestMapping("p1")
	   public String fun1(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");	      
	      return "hello";
	   }
	 @RequestMapping("/p2")
	   public String fun2(ModelMap model) {
	      model.addAttribute("message", "Hello sunny");
	      return "hello1";
	   }
	 @RequestMapping("/p3/{userId}")
	   public String fun4(@PathVariable String userId,ModelMap model) {
	      model.addAttribute("message", "Hello pan");
	      System.out.println("userId "+userId);
//	      DemoService demo = new DemoService();
//	      demo.insertUserAndTopic();
	      return "hello2";
	   }
}
