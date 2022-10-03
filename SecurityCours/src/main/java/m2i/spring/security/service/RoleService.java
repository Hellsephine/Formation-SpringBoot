package m2i.spring.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m2i.spring.security.dao.RoleRepository;
import m2i.spring.security.model.Role;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;
	
	public void createRoleIfNotExists(String roleName) {
		Optional<Role> optRole = repository.findByName(roleName);
		
		if (optRole.isEmpty())
			repository.save(new Role(roleName));
	}
}
