package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Blogger;
import com.entity.UserName;
import com.repository.IUserNameRepository;

@SpringBootTest
class UserNameServiceTest
{
	@Autowired
	UserNameService s;
	
	@MockBean
	IUserNameRepository repo;

	@Test
	void testAddNewUser() 
	{
		UserName u1=new UserName();
		u1.setUid(1);
		u1.setPassword("abc");
		u1.setRole("Blogger");
		
	   Mockito.when(repo.save(u1)).thenReturn(u1);
		
		assertThat(s.addNewUser(u1)).isEqualTo(u1);
		
	}
	
	@Test
	void testUpdateUsername()
	{
		UserName u1=new UserName();
		u1.setUid(1);
		u1.setPassword("abc");
		u1.setRole("Blogger");
		
       Optional<UserName> u2=Optional.of(u1);
		
		Mockito.when(repo.findById(1)).thenReturn(u2);
		
		Mockito.when(repo.save(u1)).thenReturn(u1);
		u1.setPassword("abc");
		u1.setRole("blogger1");
		
		assertThat(s.updateUsername(u1)).isEqualTo(u1);
		
	}



}
