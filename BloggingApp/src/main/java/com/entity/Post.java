package com.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class Post 
{
	@Id
	@GeneratedValue
	private int postId;
	@NotEmpty(message="title is required")
	private String title;
	@OneToOne(cascade = CascadeType.ALL)
	private Blogger createdBy;
	@NotEmpty(message="DateTime is required")
	private LocalDate createdDateTime;
	@OneToOne(cascade = CascadeType.ALL)
	private Comment comments;
	private int voteup;
	private int votedown;
   
//    @OneToOne(cascade = CascadeType.ALL)
//    private Community community;
    
    @Enumerated(EnumType.ORDINAL)
	@Column(name="posttype")
    private PostType content;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Blogger getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Blogger createdBy) {
		this.createdBy = createdBy;
	}

	

	public LocalDate getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDate createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Comment getComments() {
		return comments;
	}

	public void setComments(Comment comments) {
		this.comments = comments;
	}

	public int getVoteup() {
		return voteup;
	}

	public void setVoteup(int voteup) {
		this.voteup = voteup;
	}

	public int getVotedown() {
		return votedown;
	}

	public void setVotedown(int votedown) {
		this.votedown = votedown;
	}

	public PostType getContent() {
		return content;
	}

	public void setContent(PostType content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", createdBy=" + createdBy + ", createdDateTime="
				+ createdDateTime + ", comments=" + comments + ", voteup=" + voteup + ", votedown=" + votedown
				+ ", content=" + content + "]";
	}
    

}
