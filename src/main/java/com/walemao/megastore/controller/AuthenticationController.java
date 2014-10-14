package com.walemao.megastore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;









import com.walemao.megastore.domain.User;
import com.walemao.megastore.domain.UserAuthority;
import com.walemao.megastore.domain.validation.RegisterValidator;
import com.walemao.megastore.repository.UserAuthorityDao;
import com.walemao.megastore.service.MUserAuthorityService;



@Controller
public class AuthenticationController
{
	private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	private MUserAuthorityService userAuthorityService;
	
	@Autowired 
	private RegisterValidator usernameValidator;
	 
	// Display the form on the get request
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String showRegistration(@ModelAttribute("user") User user) 
    {
    	System.out.println("ffffffffffffffffffff");
		return "registration";
    }
	
    // Process the form.
    @RequestMapping(value = "reg", method = RequestMethod.POST)
    public @ResponseBody String processRegistration(@Validated @ModelAttribute("user") User user,
                    BindingResult result) 
    {
		if (result.hasErrors()) 
		{
			return result.getFieldErrors().toString();
		}
		
		System.out.println("ooooooo");
		
		if (userAuthorityService.registerUser(user))
		{
			return "registration success";
		}
		return "registration failed";
    }
    
    @RequestMapping(value = "modify_pwd", method = RequestMethod.GET)
    public @ResponseBody String changePassword(String password, String newPassword)
    {
    	int a = 0;
    	return null;
    }
    
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
    	binder.setValidator(usernameValidator);
    } 
}