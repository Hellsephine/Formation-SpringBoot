package m2i.spring.security.service;

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

import m2i.spring.security.dao.UserRepository;
import m2i.spring.security.model.Role;
import m2i.spring.security.model.User;


@Service("userDetailsService")
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		Optional<User> optUser = userRepository.findByEmail(email);
		
		if (optUser.isEmpty())
			throw new UsernameNotFoundException("Email not found");
		
		User user = optUser.get();
		
		Stream<Stream<GrantedAuthority>> nestedAuthorities = user
			.getRoles()
			.stream()
			.map(this::transformRoleAsStrings);
		
		List<GrantedAuthority> authorities = nestedAuthorities
			.flatMap(x -> x)
			.toList();
		
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), 
				user.getPassword(), 
				user.isEnabled(), // enabled
				true, // account not expired
				true, // credentials not expired
				true, // account not locked
				authorities);
	}
	
	/**
	 * Transforme les rôles en un ensemble de chaînes de caractères.
	 * 
	 * Une entrée par rôle et une entrée par privilège.
	 */
	private Stream<GrantedAuthority> transformRoleAsStrings(Role role)
	{
		int size = role.getPrivileges().size() + 1;
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(size);
		
		authorities.add(new SimpleGrantedAuthority(role.getName()));
		
		List<? extends GrantedAuthority> privileges = role.getPrivileges().stream()
				.map(p -> new SimpleGrantedAuthority(p.getName()))
				.toList();
		
		authorities.addAll(privileges);
		
		return authorities.stream();
	}

}
