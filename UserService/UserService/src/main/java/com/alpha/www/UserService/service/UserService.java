package com.alpha.www.UserService.service;

import java.util.List;

import com.alpha.www.UserService.entity.User;

public interface UserService {
	
	User createUser(User user);
	
	List<User> getAllUsers();
	
	User getUserById(String id);
}
