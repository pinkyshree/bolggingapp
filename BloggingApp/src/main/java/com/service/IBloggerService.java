package com.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.entity.Blogger;
import com.entity.Community;
import com.exception.IdNotFoundException;

@Service
public interface IBloggerService 
{
	public Blogger addBlogger(Blogger blogger);
	public Blogger updateBlogger(Blogger b) throws IdNotFoundException;
	public String deleteBloggerById(int userId);
	public Blogger viewBlogger(int userId) throws IdNotFoundException;
	public List<Blogger> viewAllBloggers();
//    public	List<Blogger> findAllCommunity(Community community);
	
}
