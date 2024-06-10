package com.eldar.challenge.entities;

import lombok.Data;

@Data
public class CardHolder {
	private int id;
	private String apyn;
	
	public CardHolder(String apyn) {
		super();
		this.apyn = apyn;
	}
}
