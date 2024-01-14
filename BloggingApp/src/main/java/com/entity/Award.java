package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Award 
{
	@Id
	private int aid;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="coin")
	private Coin coin;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Blogger blogger;
	
	@OneToOne(cascade = CascadeType.ALL)
	Community community;
	
	@OneToOne(cascade = CascadeType.ALL)
	Post post;
	

	public Coin getCoin() {
		return coin;
	}

	public void setCoin(Coin coin) {
		this.coin = coin;
	}

	

	
}
