package com.cengenes.springmvc.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cengenes.springmvc.dao.UserDao;
import com.cengenes.springmvc.model.User;
import com.cengenes.springmvc.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		return userDao.findOne(id);
	}

	@Override
	public User findUserWithBlogPostByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.findUserByUserName(userName);
	}

}
