package com.alpha.www.UserService.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alpha.www.UserService.entity.Rating;
import com.alpha.www.UserService.entity.User;
import com.alpha.www.UserService.exception.ResourceNotFoundException;
import com.alpha.www.UserService.repository.UserRepository;
import com.alpha.www.UserService.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
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
		// get user from database
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with id: "+id));
		
		// fetch ratings of above user from RATING-SERVICE
		// localhost:8083/ratings/users/51f2d7c0-052d-4be9-adce-3b70c33fdade
		ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);
		logger.info("{} ", ratingsOfUser);
		
		user.setRatings(ratingsOfUser);
		
		return user;
	}

}
