package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Blogger;
import com.entity.Post;

@Service
public interface IPostService 
{
	public Post addPost(Post p);
	public Post updatePost(Post post);
	public String deletePostById(int postId);
	public Post viewPost(int id);
	public List<Post> viewAllPosts();
	
	

}
