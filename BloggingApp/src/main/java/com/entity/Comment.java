package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class Comment
{
	@Id
	@GeneratedValue
	private int commentId;
	@NotEmpty(message="Description is required")
	private String commentDescription;
	@NotEmpty(message="no of votes is required")
	private int votes;
	@OneToOne(cascade = CascadeType.ALL)
	private Blogger blogger;
	@OneToOne(cascade = CascadeType.ALL)

	private Post post;
	private int voteUp;
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentDescription() {
		return commentDescription;
	}
	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public Blogger getBlogger() {
		return blogger;
	}
	public void setBlogger(Blogger blogger) {
		this.blogger = blogger;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public int getVoteUp() {
		return voteUp;
	}
	public void setVoteUp(int voteUp) {
		this.voteUp = voteUp;
	}
	
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentDescription=" + commentDescription + ", votes=" + votes
				+ ", blogger=" + blogger + ", post=" + post + ", voteUp=" + voteUp + "]";
	}
	
	
	
}
