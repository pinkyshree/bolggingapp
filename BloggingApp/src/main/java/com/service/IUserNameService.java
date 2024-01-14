package com.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.entity.UserName;

@Service
public interface IUserNameService 
{
	public  UserName addNewUser( UserName user);
	public  UserName signIn( UserName user);
	public  UserName signOut( UserName user);
	public List<UserName> getUser();
	public UserName getUsernameById(int uid) throws Exception;
    public UserName updateUsername(UserName u);

}
