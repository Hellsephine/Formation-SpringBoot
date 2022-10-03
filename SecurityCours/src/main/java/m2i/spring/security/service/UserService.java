package m2i.spring.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import m2i.spring.security.dao.RoleRepository;
import m2i.spring.security.dao.UserRepository;
import m2i.spring.security.dto.UserDto;
import m2i.spring.security.model.Role;
import m2i.spring.security.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User createUser(UserDto userDto)
	{
		Role userRole = roleRepository.findByName("USER").get();
		List<Role> roles = new ArrayList<Role>();
		roles.add(userRole);
		
		User user = new User(
				userDto.getEmail(),
				passwordEncoder.encode(userDto.getPassword()),
				true, // enabled
				roles
				);
		
		return userRepository.save(user);
	}
}
