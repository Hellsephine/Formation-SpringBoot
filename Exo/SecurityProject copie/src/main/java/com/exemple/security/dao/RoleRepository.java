package com.exemple.security.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exemple.security.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{

	Optional<Role> findByName(String user);
	
}
