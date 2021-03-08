package com.aa.awesomecareer.entity;

public enum Activation { 
	ACTIVATED(1), UNACTIVATED(0);
	
	public final int value;

	Activation(int value) {
		this.value = value;
	} 
}