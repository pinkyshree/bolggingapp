package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Comment;
import com.entity.Post;
import com.service.CommentService;

@RestController
@RequestMapping(path="/api")
@CrossOrigin
public class CommentController
{
	@Autowired//instance are injected in spring boot
	CommentService service;
	
	@PostMapping("/addComment")
	public Comment addComment(@RequestBody Comment comment) 
	{
		Comment c=service.addComment(comment);
		return c;
	}
	
	@DeleteMapping(path="/deleteComment/{commentId}")
	public String deleteCommentById(@PathVariable int commentId)
	{
		service.deleteCommentById(commentId);
		return "Deleted";
	}
	
	@GetMapping("/getComments")
	public List<Comment> viewAllComment()
	{
		
		List<Comment> lc=service.viewAllComment();
		return lc;
	}
	
	@GetMapping("/getComment/{commentId}")
	public Comment getCommentById(@PathVariable int id) {
		Comment c=service.getCommentById( id);
		return c;
	
	}
	
	
	

}
