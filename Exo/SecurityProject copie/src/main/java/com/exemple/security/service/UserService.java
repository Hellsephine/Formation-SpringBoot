package com.exemple.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exemple.security.dao.RoleRepository;
import com.exemple.security.dao.UserRepository;
import com.exemple.security.dto.UserDto;
import com.exemple.security.model.Role;
import com.exemple.security.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User createUser(UserDto userDto) {
		
		Role userRole = roleRepository.findByName("USER").get();
		List<Role> roles = new ArrayList<Role>();
		roles.add(userRole);
		
		User user = new User(userDto.getEmail(),
				passwordEncoder.encode(userDto.getPassword()),
				true,
				roles
				);
		
		return userRepository.save(user);
	}
	
	
}
