package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Blogger;
import com.entity.Community;
import com.exception.IdNotFoundException;

@Service
public interface ICommunityService
{
	public Community addCommunity(Community community);
	public Community updateCommunity(Community community);
	public String deleteCommunityById(int communityId);
	public Community viewCommunity(int id);
	public List<Community> viewAllCommunitys();

	

}
