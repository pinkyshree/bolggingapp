package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.UserName;
import com.repository.IUserNameRepository;

@Service
public class UserNameService implements IUserNameService
{
	@Autowired
	IUserNameRepository repo;
	private ArrayList le;
	
	public UserName addNewUser(UserName user) 
		{
			repo.save(user);
			return user;	
		}
	
	public UserName signOut(UserName user)
	{
		
		return null;
	}
	
	public UserName signIn(UserName   user) 
	{
		
		return null;	
	}

	@Override
	public List<UserName> getUser()
	{
		le=new ArrayList<>();
		List<UserName> u1=repo.findAll();
		return u1;
	}

	@Override
	public UserName getUsernameById(int uid) throws Exception
	{
		UserName u1=repo.findById(uid).orElseThrow();
		
		return u1;
	}

	@Override
	public UserName updateUsername(UserName u) 
	{
		int uid=u.getUid();
		UserName u1=repo.findById(uid).orElse(null);
		u1.setPassword(u.getPassword());
		u1.setRole(u.getRole());
		repo.save(u1);
		return u1;
	}
	
	


}
