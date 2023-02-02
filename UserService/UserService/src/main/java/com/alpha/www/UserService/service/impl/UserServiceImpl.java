package com.alpha.www.UserService.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.www.UserService.entity.User;
import com.alpha.www.UserService.exception.ResourceNotFoundException;
import com.alpha.www.UserService.repository.UserRepository;
import com.alpha.www.UserService.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		String randomId = UUID.randomUUID().toString();
		user.setUserId(randomId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id: "+id));
	}

}
