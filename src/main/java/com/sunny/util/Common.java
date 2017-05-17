package com.sunny.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Common{
	private static ApplicationContext apptx = null;
	public static ApplicationContext getApplicationContext(){
		if(apptx==null){
			apptx = new ClassPathXmlApplicationContext("applicationContext.xml");
			return apptx;
		}
		return apptx;
	}
}
