package com.exemple.security.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

import com.exemple.security.service.RoleService;

@Component
public class RoleInitListener implements ApplicationListener<ApplicationContextEvent> {

	@Autowired
	private RoleService roleService;
	
	@Override
	public void onApplicationEvent(ApplicationContextEvent event) {
		roleService.createRoleIfNotExists("ADMIN");
		roleService.createRoleIfNotExists("USER");

	}
	
	
	
}
