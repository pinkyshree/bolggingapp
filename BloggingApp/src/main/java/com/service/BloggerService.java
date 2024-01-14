package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Blogger;
import com.entity.Community;
import com.exception.IdNotFoundException;
import com.repository.IBloggerRepository;

@Service
public class BloggerService implements IBloggerService
{
	@Autowired
	IBloggerRepository repo;

	@Override
	public Blogger addBlogger(Blogger blogger) 
	{
		repo.save(blogger);
		return blogger;
	}
	
	public List<Blogger> viewAllBlogger()
	{
		List<Blogger> lb=repo.findAll();
		return lb;
	}

	@Override
	public Blogger updateBlogger(Blogger b) throws IdNotFoundException 
	{
		int id=b.getUserId();
		Blogger b1=repo.findById(id).orElse(b);
		b1.setFirstname(b.getFirstname());;
		b1.setLastname(b.getLastname());
		repo.save(b1);
		return b1;
	}

	@Override
      public String deleteBloggerById(int userId) {
		
		repo.deleteById(userId);
		
		return "Deleted";
	}

	@Override
	public Blogger viewBlogger(int id) throws IdNotFoundException
	{
		Blogger b=repo.findById(id).orElse(null);
		return b;
	}

	@Override
	public List<Blogger> viewAllBloggers() 
	{
		List<Blogger> lb=repo.findAll();
		return lb;
	}

	
}
