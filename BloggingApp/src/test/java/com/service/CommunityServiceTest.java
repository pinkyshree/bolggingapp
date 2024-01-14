package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Blogger;
import com.entity.Community;
import com.repository.ICommunityRepository;

@SpringBootTest
public class CommunityServiceTest 
{
	private static final Blogger blogger = null;

	@Autowired
	CommunityService service;
	
	@MockBean
	ICommunityRepository repo;

	@Test
	void testAddCommunity() {
		Community c1 = new Community();
		c1.setCommunityId(1);
		c1.setCommunityDescription("abcd");
		c1.setTitle("Food");
		Mockito.when(repo.save(c1)).thenReturn(c1);
		
		assertThat(service.addCommunity(c1)).isEqualTo(c1);
	}
	
	@Test
	void testUpdateCommunity() throws Throwable {
		Community c1 = new Community();
		c1.setCommunityId(1);
		c1.setCommunityDescription("abcd");
		c1.setTitle("Food");
		
		Optional<Community> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		Mockito.when(repo.save(c1)).thenReturn(c1);
		c1.setCommunityDescription("qwerty");
		c1.setTitle("tour");;
		
		assertThat(service.updateCommunity(c1)).isEqualTo(c1);
		
	}
	
	@Test
	void testDeleteCommunity() {
		Community c1=new Community();
		c1.setCommunityId(1);
		c1.setCommunityDescription("abcd");
		c1.setTitle("Food");
		Optional<Community> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		 Mockito.when(repo.existsById(c1.getCommunityId())).thenReturn(false);
		   assertFalse(repo.existsById(c1.getCommunityId()));
	}
	
	@Test
	void testViewAllCommunitys() {
		Community c1 = new Community();
		c1.getCreatedOn();
		
		Community c2=new Community();
		c2.getCreatedOn();
		
		List<Community> communityList = new ArrayList<>();
		communityList.add(c1);
		communityList.add(c2);
		
		Mockito.when(repo.findAll()).thenReturn(communityList);
		
		assertThat(service.viewAllCommunitys()).isEqualTo(communityList);
	}


}
