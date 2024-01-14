package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Blogger;
import com.entity.Community;
import com.repository.ICommunityRepository;

@Service
public class CommunityService implements ICommunityService 
{
	@Autowired
	ICommunityRepository comrepo;
	
	public Community addCommunity(Community community) 
	{
		Community c=comrepo.save(community);
		return c;
	}
	
		
	public Community updateCommunity(Community community) {
		int id=community.getCommunityId();
		Community c=comrepo.findById(id).orElse(null);
		c.setCommunityDescription(community.getCommunityDescription());
		c.setTitle(community.getTitle());
		
		comrepo.save(c);
		return c;
	}
	
	
	 public String deleteCommunityById(int communityId) {
			
			comrepo.deleteById(communityId);
			
			return "Deleted";
		}


	@Override
	public Community viewCommunity(int id) {
		Community c=comrepo.findById(id).orElse(null);
		return c;
	}


	@Override
	public List<Community> viewAllCommunitys() {
		List<Community> lc= comrepo.findAll();
		return lc;
	}

	
	
	

}
