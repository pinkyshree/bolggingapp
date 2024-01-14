package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.Comment;
import com.entity.Post;
import com.repository.ICommentRepository;

@Service
public class CommentService implements ICommentService
{
	@Autowired
	ICommentRepository repo;

	@Override
	public Comment addComment(Comment comment) 
	{
		repo.save(comment);
		return comment;
	}

	@Override
   public String deleteCommentById(int commentId) {
		
		repo.deleteById(commentId);
		
		return "Deleted";
	}

	@Override
	public List<Comment> viewAllComment()
	{
		
		List<Comment>lc=repo.findAll();
		return lc;
	}

	@Override
	public Comment getCommentById(int id) {
		Comment c=repo.findById(id).orElse(null);
		return c;
	}

	
}
