package com.walemao.megastore.service;

import java.util.Date;

import com.walemao.megastore.domain.CurrentPage;
import com.walemao.megastore.domain.User;

public interface MUserAuthorityService 
{	
	public boolean registerUser(User user);
	
	public boolean changePassword(String username, String oldRawPassword, String newRawPassword);
}
