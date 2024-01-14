package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.entity.UserName;
import com.service.UserNameService;

@RestController
@RequestMapping(path="/api")
@CrossOrigin
public class UserNameController 
{
	
		@Autowired
		UserNameService userservice;
		
		@RequestMapping("/hello")
		//@ResponseBody
		public String hello()
		{
			return "Welcome to Spring MVC";
		}
		
		@GetMapping("/getUsers")
		public List<UserName> getUsers()
		{
			List<UserName> lu=userservice.getUser();
			return lu; 
			
		}
		
		@GetMapping(path="/getUserName/{uid}")
		public UserName getUserNameById(@PathVariable int uid) throws Exception
		{
			UserName u1=userservice.getUsernameById(uid);
			return u1;
		}
		
		@PostMapping("/addUsernames")
		public UserName addNewUser(@RequestBody UserName c)
		{
			userservice.addNewUser(c);
			return c;
		}
		
		@RequestMapping(value="/signout/{userId}", method=RequestMethod.GET)
		public String welcomepage(@PathVariable int userId) {
			return "USER_ID --> "+userId+" IS  SIGNED OUT ";
		}
		
		@RequestMapping(value="/signin/{userId}", method=RequestMethod.GET)
		public String welcomepage1(@PathVariable int userId) {
			return "USER_ID --> "+userId+" IS  SIGNED IN ";
		}
		
		@PutMapping("/updateUsername")
		public UserName updateUsername(@RequestBody UserName u)
		{
			UserName u1=userservice.updateUsername(u);
		    return u1;   	
		}

}
