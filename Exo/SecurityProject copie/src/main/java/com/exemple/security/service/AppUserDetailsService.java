package com.exemple.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exemple.security.dao.UserRepository;
import com.exemple.security.model.Role;
import com.exemple.security.model.User;

@Service("userDetailsService")
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<User>optUser=userRepository.findByEmail(email);
		
		if(optUser.isEmpty())
			throw new UsernameNotFoundException("Email not found");
		
		User user = optUser.get();
		
		List<GrantedAuthority> authorities = user
				.getRoles()
				.stream()
				.flatMap(this::transformRoleAsString)
				.toList();
		
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(),
				user.getPassword(),
				user.isEnabled(),
				true,
				true,
				true,
				authorities);
	}
	
	private Stream<GrantedAuthority> transformRoleAsString(Role role){
		
		int size = role.getPrivileges().size()+1;
		
				
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(size);
		
		authorities.add(new SimpleGrantedAuthority(role.getName()));
		
		List<? extends GrantedAuthority> privilege = role.getPrivileges().stream()
				.map(p->new SimpleGrantedAuthority(p.getName()))
				.toList();		
		
		authorities.addAll(privilege);
		
		return authorities.stream();
	}

	
}
