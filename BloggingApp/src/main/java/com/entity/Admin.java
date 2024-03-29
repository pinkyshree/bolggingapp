package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin 
{
	@Id
	@GeneratedValue
	private int userId;
	private String adminName;
	private String adminContact;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminContact() {
		return adminContact;
	}
	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}
	@Override
	public String toString() {
		return "Admin [userId=" + userId + ", adminName=" + adminName + ", adminContact=" + adminContact + "]";
	}



}
