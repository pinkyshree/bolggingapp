package com.entity;

import java.io.File;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class Community 
{
	@Id
	@GeneratedValue
	private int communityId;
	@NotEmpty(message="Descrption is required")
	private String communityDescription;
	private String title;
	@NotEmpty(message="image name is required")
	private String image;
	@NotEmpty(message="Date and time is required")
	private LocalDate createdOn;
	
	
	public int getCommunityId() {
		return communityId;
	}
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	public String getCommunityDescription() {
		return communityDescription;
	}
	public void setCommunityDescription(String communityDescription) {
		this.communityDescription = communityDescription;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public LocalDate getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}
	@Override
	public String toString() {
		return "Community [communityId=" + communityId + ", communityDescription=" + communityDescription + ", title="
				+ title + ", image=" + image + ", createdOn=" + createdOn + "]";
	}	
	
    
}
