package com.cengenes.springmvc.service;



import com.cengenes.springmvc.model.User;

public interface UserService {
	
	
	void saveUser(User user);
    void deleteUser(User user);
    User findUserById(Long id);
    User findUserWithBlogPostByUserName(String userName);
}
