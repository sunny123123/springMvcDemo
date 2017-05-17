package com.sunny.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.sunny.util.Common;
import com.sunny.util.DBSession;

public class DemoService {
	Logger LOG = Logger.getLogger(DemoService.class);
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	public void insertUserAndTopic(){
		jdbcTemplate = new JdbcTemplate(dataSource);
		//jdbcTemplate.update("insert into user(uName,uPass) values(?,?)","panz","123");
		/*
		 * 获得插入记录的主键值
		 */
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement("insert into user(uName,uPass) values(?,?)",new String[]{"uId"});
				ps.setString(1, "pan");
				ps.setString(2, "123");
				return ps;
			}
		}, keyHolder);
		LOG.info("key is:"+keyHolder.getKey());
		jdbcTemplate.update("insert into topic(title,content,uID) values(?,?,?)","panz","123",keyHolder.getKey());
	}
	/*
	 * 测试事务，生效
	 */
	public void addUser(){
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update("insert into user(uName,uPass) values(?,?)", "panz2","2");
		jdbcTemplate.update("insert into user(uName,uPass) values(?,?)", "panz1");
		
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
