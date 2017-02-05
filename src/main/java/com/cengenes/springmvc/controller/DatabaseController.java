package com.cengenes.springmvc.controller;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class DatabaseController {
	
	private static final Logger LOGGER =LoggerFactory.getLogger(DatabaseController.class);
	
	@Autowired
	@Qualifier("MySQLDs")
	private DataSource mySQLDataSource;
	
	
	private JdbcTemplate jdbcTemplate;
	
	
	@RequestMapping(value="/displayUsersMySQL")
	public void displayUsers(){
		
		// MySQL DATABASE
		jdbcTemplate=new JdbcTemplate(mySQLDataSource);
		List<Map<String, Object>> userList = jdbcTemplate.queryForList("SELECT * FROM USER");
		for (Map<String, Object> user : userList) {
			
			LOGGER.debug("MySQLusername : " +user.get("userName"));
		}
		
	}

}
