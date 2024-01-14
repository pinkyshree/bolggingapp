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
import com.entity.Post;
import com.service.IPostService;

@RestController
@RequestMapping(path="/api")
@CrossOrigin
public class PostController 
{
	@Autowired
	IPostService service;
	
	@PostMapping(path="/addPost")
	public Post addPost(@RequestBody Post post)
	{
		Post p=service.addPost(post);
		return p;
	}
	
	@PutMapping(path="/updatePost")
	public Post updatePost(@RequestBody Post post)
	{
		Post p=service.updatePost(post);
		return p;
	}
	
	@DeleteMapping(path="/deletePost/{postId}")
	public String deletePostById(@PathVariable int postId)
	{
		service.deletePostById(postId);
		return "Deleted";
	}
	
	@GetMapping("getPosts")
	public List<Post> viewAllPosts()
	{
		List<Post> lp=service.viewAllPosts();
		return lp;
	}
	
	@GetMapping("getPost/{PostId}")
	public Post viewPost(@PathVariable int postId)
	{
		Post p=service.viewPost(postId);
		return p;
	}
	
	
}
