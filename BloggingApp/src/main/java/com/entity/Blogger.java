package com.entity;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class Blogger 
{
	@Id
	@GeneratedValue
	private int userId;
	@NotEmpty(message="Blogger name is required")
	private String firstname;
	private String lastname;
	private String typeblogger;
	@OneToOne(cascade = CascadeType.ALL)
	private Post posts;
	@OneToOne(cascade = CascadeType.ALL)
	private Comment comments;
	@OneToOne(cascade = CascadeType.ALL)
    private Community communities;
	@NotEmpty(message="number is required")
	private LocalDate dateofBirth;
	private String gender;
	private String feedback;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTypeblogger() {
		return typeblogger;
	}
	public void setTypeblogger(String typeblogger) {
		this.typeblogger = typeblogger;
	}
	
//	
//	
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
	public Post getPosts() {
		return posts;
	}
	public void setPosts(Post posts) {
		this.posts = posts;
	}
	public Comment getComments() {
		return comments;
	}
	public void setComments(Comment comments) {
		this.comments = comments;
	}
	
	
	public LocalDate getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(LocalDate dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Community getCommunities() {
		return communities;
	}
	
	public void setCommunities(Community communities) {
		this.communities = communities;
	}
	
	@Override
	public String toString() {
		return "Blogger [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", typeblogger="
				+ typeblogger + ", posts=" + posts + ", comments=" + comments + ", communities=" + communities
				+ ", dateofBirth=" + dateofBirth + ", gender=" + gender + ", feedback=" + feedback + "]";
	}
	
	
		
}
