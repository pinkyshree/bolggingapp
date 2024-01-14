package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Blogger;
import com.entity.Post;
import com.repository.IPostRepository;

@Service
public class PostService implements IPostService
{
	@Autowired
	IPostRepository repo;

	@Override
	public Post addPost(Post p) 
	{
		repo.save(p);
		return p;
	}

	@Override
	public Post updatePost(Post post) 
	{
		int id=post.getPostId();
		Post p=repo.findById(id).orElse(null);
		p.setTitle(post.getTitle());
		p.setVoteup(post.getVoteup());
		repo.save(p);
		return p;	
	}

	@Override
 public String deletePostById(int postId) {
		
		repo.deleteById(postId);
		
		return "Deleted";
	}

	

	@Override
	public Post viewPost(int id) {
		Post p=repo.findById(id).orElse(null);
		return p;
	}

	@Override
	public List<Post> viewAllPosts() {
		List<Post> lp=repo.findAll();
		return lp;
	}

	

}
