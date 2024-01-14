package com.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.entity.Comment;
import com.entity.Post;


@Service
public interface ICommentService 
{
	public Comment addComment(Comment comment);
	public String deleteCommentById(int commentId);
	public List<Comment> viewAllComment();
	public Comment getCommentById(int id);
	

}
