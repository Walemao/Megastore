package com.walemao.megastore.domain.Authentication;


import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import com.walemao.megastore.domain.User;


public class RegistrationUsernameProvider extends DaoAuthenticationProvider
{
	public RegistrationUsernameProvider() 
	{
		super();
	}

	public String encodePassword(User user)
	{
		String salt = user.getUserName();
		return this.getPasswordEncoder().encodePassword(user.getPassword(), salt);
	}
}
