package br.com.caelum.vraptor.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class World {
	
	@Id @GeneratedValue
	private int id;
	
	private int randomNumber;
	
	public World() {}
	
	public World(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	public long getRandomNumber() {
		return randomNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}