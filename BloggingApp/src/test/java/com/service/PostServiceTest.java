package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Blogger;
import com.entity.Post;
import com.repository.IPostRepository;

@SpringBootTest
class PostServiceTest 
{
	private static final Blogger blogger = null;

	@Autowired
	PostService s;
	
	@MockBean
	IPostRepository repo;

	@Test
	void testAddPost() {
		Post p=new Post();
		p.setPostId(1);
		p.setTitle("Learning1");
		p.setVoteup(6);
	   Mockito.when(repo.save(p)).thenReturn(p);
		
		assertThat(s.addPost(p)).isEqualTo(p);
	}

	@Test
	void testUpdatePost() 
	{
		Post p=new Post();
		p.setPostId(1);
		p.setTitle("Learning1");
		p.setVoteup(5);
		Optional<Post> p1=Optional.of(p);
		
		Mockito.when(repo.findById(1)).thenReturn(p1);
		p.setTitle("Learning1");
		p.setVoteup(5);
		
		assertThat(s.updatePost(p)).isEqualTo(p);
	}

	@Test
	void testDeletePost()
	{
		Post p=new Post();
		p.setPostId(1);
		p.setTitle("Learning1");
		p.setVoteup(5);
		Optional<Post> p1=Optional.of(p);
	
		Mockito.when(repo.findById(1)).thenReturn(p1);
		Mockito.when(repo.existsById(p.getPostId())).thenReturn(false);
		   assertFalse(repo.existsById(p.getPostId()));	
	}
	
	@Test
	 void testViewAllPosts()
	{
		Post p=new Post();
		p.setPostId(1);
		p.setTitle("Learning1");
		p.setVoteup(5);
		
		Post p1=new Post();
		p1.setPostId(2);
		p1.setTitle("Learning");
		p1.setVoteup(7);
		
		List<Post> PostList = new ArrayList<>();
		PostList.add(p);
		PostList.add(p1);
		
		Mockito.when(repo.findAll()).thenReturn(PostList);
		
		assertThat(s.viewAllPosts()).isEqualTo(PostList);
	}
	
	


}
