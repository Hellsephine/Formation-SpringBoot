package com.exemple.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.security.dao.RoleRepository;
import com.exemple.security.model.Role;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public void createRoleIfNotExists(String roleName) {
		Optional<Role> optRole = roleRepository.findByName(roleName);
		
		if (optRole.isEmpty())
			roleRepository.save(new Role(roleName));
	}
}
