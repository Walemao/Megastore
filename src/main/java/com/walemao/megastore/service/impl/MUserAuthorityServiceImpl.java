package com.walemao.megastore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walemao.megastore.domain.User;
import com.walemao.megastore.domain.UserAuthority;

import com.walemao.megastore.domain.rel.UsernameAuthenticatonProvider;
import com.walemao.megastore.repository.UserAuthorityDao;
import com.walemao.megastore.repository.UserDao;

import com.walemao.megastore.service.MUserAuthorityService;

@Service
public class MUserAuthorityServiceImpl implements MUserAuthorityService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserAuthorityDao userAuthorityDao;
	
	@Autowired
	private UsernameAuthenticatonProvider provider;
	
	
	@Override
	public boolean registerUser(User user)
	{
		if (userDao.CheckUsername(user.getUsername()))
		{
			return false;
		}
		
		user.setPassword(provider.encodeRegisterPassword(user.getUsername(), user.getPassword()));
		user.setSalt(user.getUsername());
		userDao.insert(user);
		
		UserAuthority author = new UserAuthority();
		author.setUsername(user.getUsername());
		author.setAuthority("ROLE_USER");
		userAuthorityDao.insert(author);
		return true;
	}

	@Override
	public boolean changePassword(String username, String oldRawPassword, String newRawPassword) 
	{
		if (userDao.CheckUsername(username))
		{
			return false;
		}
		
		if (!provider.isUserPasswordValid(username, oldRawPassword))
		{
			return false;
		}
		
		userDao.updatePasswd(username, newRawPassword);
		
		return true;
	}
}
