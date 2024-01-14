package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Blogger;
import com.entity.Community;
import com.service.CommunityService;

@RestController
@RequestMapping(path="/api")
@CrossOrigin
public class CommunityController 
{
	@Autowired
	CommunityService service;
	
	@PostMapping(path="/addCommunity")
	public Community addCommunity(@RequestBody Community c)
	{
		Community c1 = service.addCommunity(c);
		return c1;
	}
	
	@PutMapping(path="/updateCommunity")
	public Community updateCommunity(@RequestBody Community c)
	{
		Community c1=service.updateCommunity(c);
		
		return c1;
	}
	
	@DeleteMapping(path="/deleteCommunity/{communityId}")
	public String deleteCommunityById(@PathVariable int communityId)
	{
		service.deleteCommunityById(communityId);
		return "Deleted";
	}
	
     @GetMapping(path="/getCommunity/{communityId}")
     public Community viewCommunity(@PathVariable int communityId)
     {
    	 Community c=service.viewCommunity(communityId);
    	 return c;
    	 
     }
	
     @GetMapping(path="/getCommunitys")
     public List<Community> viewAllCommunitys()
     {
    	 List<Community> lc=service.viewAllCommunitys();
    	 return lc;
     }


}
