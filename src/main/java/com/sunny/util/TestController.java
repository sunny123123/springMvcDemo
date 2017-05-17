package com.sunny.util;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
	 /*
	  * http://localhost:8080/springMVC 使用的hello2.jsp
	  */
	 @RequestMapping(value="",produces="application/json")
	   public String fun3(ModelMap model) {
	      model.addAttribute("message", "Hello pan");
	      return "hello21";
	   }
	 @RequestMapping(value="/p1",method = RequestMethod.GET)
	   public String fun1(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");	      
	      return "hello";
	   }
	 @RequestMapping(value="/p2",produces="application/json")
	 @ResponseBody
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
