package com.springboot.user.service.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.user.service.entities.User;
import com.springboot.user.service.exception.ResourseNotFoundException;
import com.springboot.user.service.repostories.UserRepository;

@Service
public class UserServiceImple implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		String randomUserID = UUID.randomUUID().toString();
		user.setUserId(randomUserID);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUser(String id) {
	
		return userRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("User with given id is not found on server !!:"));
	}

}
