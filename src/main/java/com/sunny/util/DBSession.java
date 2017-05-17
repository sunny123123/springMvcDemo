package com.sunny.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBSession {
	public static Connection getConnection(){
		ApplicationContext apptx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource ds = (DataSource)apptx.getBean("dataSource");
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
	public static DataSource getDataSource(){
		ApplicationContext apptx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource ds = (DataSource)apptx.getBean("dataSource");
		return ds;
	}

}
