package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Blogger;
import com.entity.Comment;
import com.repository.ICommentRepository;

@SpringBootTest
public class CommentServiceTest
{
	private static final Blogger comment = null;

	@Autowired
	CommentService service;
	
	@MockBean
	ICommentRepository repo;
	
	@Test
	void testAddComment() {
		Comment c1 = new Comment();
		c1.setCommentId(1);
		c1.setCommentDescription("abcd");
		c1.setVotes(20);
		Mockito.when(repo.save(c1)).thenReturn(c1);
		
		assertThat(service.addComment(c1)).isEqualTo(c1);
	}
	
	
	
	@Test
	void testDeleteCommentById() {
		Comment c1=new Comment();
		c1.setCommentId(1);
		c1.setCommentDescription("abcdefg");
		c1.setVotes(10);
		Optional<Comment> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		 Mockito.when(repo.existsById(c1.getCommentId())).thenReturn(false);
		   assertFalse(repo.existsById(c1.getCommentId()));
	}
	
	@Test
	void testViewAllComment() {
		Comment c1 = new Comment();
		c1.setBlogger(comment);
		
		Comment c2=new Comment();
		c2.setBlogger(comment);
		
		List<Comment> commentList = new ArrayList<>();
		commentList.add(c1);
		commentList.add(c2);
		
		Mockito.when(repo.findAll()).thenReturn(commentList);
		
		assertThat(service.viewAllComment()).isEqualTo(commentList);
	}

}
