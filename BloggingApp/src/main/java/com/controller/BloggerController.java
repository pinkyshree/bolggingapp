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
import com.exception.IdNotFoundException;
import com.repository.IBloggerRepository;
import com.service.BloggerService;


@RestController
@RequestMapping(path="/api")
@CrossOrigin
public class BloggerController 
{
	@Autowired
	BloggerService service;
	
	@Autowired
	IBloggerRepository rrepo;
	
	@PostMapping("/addBlogger")
	public Blogger addBlogger(@RequestBody Blogger blogger)
	{
		Blogger b=service.addBlogger(blogger);
		return b;
	}
	
	
	@PutMapping("/updateBlogger")
	public Blogger updateBlogger(@RequestBody Blogger blogger) throws IdNotFoundException
	{
		Blogger b=service.updateBlogger(blogger);
		return b;
	}
	
	@DeleteMapping(path="/deleteBlogger/{userId}")
	public String deleteBloggerById(@PathVariable int userId)
	{
		service.deleteBloggerById(userId);
		return "Deleted";
	}
	
	
	@GetMapping(path="/getBlogger/{userId}")
	public Blogger viewBlogger(@PathVariable int userId) throws IdNotFoundException 
	{
		Blogger b=service.viewBlogger(userId);
		return b;
	}
	
	@GetMapping("/getBloggers")
	public List<Blogger> viewAllBloggers()
	{
		List<Blogger> lb=service.viewAllBloggers();
		return lb;
	}
	
	
	
	
	}
	
	


