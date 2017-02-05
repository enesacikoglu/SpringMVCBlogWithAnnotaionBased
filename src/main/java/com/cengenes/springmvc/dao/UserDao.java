package com.cengenes.springmvc.dao;

import org.springframework.data.repository.CrudRepository;


import com.cengenes.springmvc.model.User;

public interface UserDao extends CrudRepository<User, Long>{

	//custom methods
	User findUserByUserName(String userName);
	
	
	
}
