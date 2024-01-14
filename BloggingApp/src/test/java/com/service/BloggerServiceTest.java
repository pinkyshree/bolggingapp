package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
import com.entity.Community;
import com.repository.IBloggerRepository;

@SpringBootTest
public class BloggerServiceTest 
{
	private static final Community community = null;

	@Autowired
	BloggerService service;
	
	@MockBean
	IBloggerRepository repo;
	
	@Test
	void testAddBlogger() {
		Blogger b1 = new Blogger();
		b1.setUserId(1);;
		b1.setFirstname("Sushmitha");
		b1.setLastname("Bingi");
		
		Mockito.when(repo.save(b1)).thenReturn(b1);
		
		assertThat(service.addBlogger(b1)).isEqualTo(b1);
	}
	
	@Test
	void testUpdateBlogger() throws Throwable {
		Blogger b1 = new Blogger();
		b1.setUserId(1);;
		b1.setFirstname("Sushmitha");
		b1.setLastname("Bingi");
		
		Optional<Blogger> b2=Optional.of(b1);
		
		Mockito.when(repo.findById(1)).thenReturn(b2);
		
		Mockito.when(repo.save(b1)).thenReturn(b1);
		b1.setFirstname("Sushmitha");
		b1.setLastname("Bingi");
		
		assertThat(service.updateBlogger(b1)).isEqualTo(b1);
		
	}
	
	@Test
	void testDeleteBlogger() {
		Blogger b1 = new Blogger();
		b1.setUserId(1);;
		b1.setFirstname("Sushmitha");
		b1.setLastname("Bingi");
		
		Optional<Blogger> b2=Optional.of(b1);
		
		Mockito.when(repo.findById(1)).thenReturn(b2);
		 Mockito.when(repo.existsById(b1.getUserId())).thenReturn(false);
		   assertFalse(repo.existsById(b1.getUserId()));
	}
	
	@Test

	void testViewAllBlogger() 
	{
		Blogger b1 = new Blogger();
		b1.setUserId(1);
		b1.setFirstname("Sushmitha");
		b1.setLastname("Bingi");
		
		Blogger b2 = new Blogger();
		b2.setUserId(2);
		b2.setFirstname("Srithan");
		b2.setLastname("Reddy");
		
		List<Blogger> BloggerList = new ArrayList<>();
		BloggerList.add(b1);
		BloggerList.add(b2);
		
		Mockito.when(repo.findAll()).thenReturn(BloggerList);
		
		assertThat(service.viewAllBlogger()).isEqualTo(BloggerList);
	}
		
	@Test
	void testViewAllCommunity()
	{
		Blogger b1=new Blogger();
		b1.getCommunities();
		
		Blogger b2=new Blogger();
		b2.getCommunities();
		
		List<Blogger> BloggerList = new ArrayList<>();
		BloggerList.add(b1);
		BloggerList.add(b2);
		
		Mockito.when(repo.findAll()).thenReturn(BloggerList);
		
		assertThat(service.viewAllBlogger()).isEqualTo(BloggerList);
	}
	


}
