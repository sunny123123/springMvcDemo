package com.sunny.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sunny.service.DemoService;

public class AppTest {
	private JdbcTemplate jdbcTemplate = null;
	
	public void testConnection(){
		DBSession op = new DBSession();
		Connection conn = op.getConnection();
		String sql = "select * from user";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("uName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void testJdbcTemplate(){
		DBSession session = new DBSession();
		DataSource dataSource = session.getDataSource();
		jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> users = jdbcTemplate.queryForList("select * from user");
		JSONArray jsonArray = new JSONArray(users);
		System.out.println(jsonArray.toString());	
	}
	public void testTransaction(){
		//String dir = System.getProperty("user.dir");
		//System.out.println(dir+"\\src\\main\\java\\applicationContext.xml");
		ApplicationContext apptx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DemoService demoService = (DemoService)apptx.getBean("demoService");

		demoService.insertUserAndTopic();
	}
	public static void main(String[] args) {
		//new AppTest().testTransaction();
		ApplicationContext apptx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DemoService ser = (DemoService)apptx.getBean("demoService");
		ser.addUser();
	}
	@Test
	public void testApp(){
		testTransaction();
	}

}
