package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;

@Entity
@Validated
public class UserName 
{
	@Id
	@GeneratedValue
	private int uid;
	private String username; 
	@NotEmpty(message="password required")
	private String password;
	@NotEmpty(message="role required")
	private String role;
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "UserName [uid=" + uid + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	


}
