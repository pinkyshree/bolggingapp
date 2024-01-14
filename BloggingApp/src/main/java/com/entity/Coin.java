package com.entity;

public enum Coin {
	
SILVER(200),GOLD(500),PLATINUM(700),REGULAR(100);
 @SuppressWarnings("unused")
private int value;
 

Coin(int i) {
this.value=i;	

}
}