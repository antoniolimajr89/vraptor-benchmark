package br.com.caelum.vraptor.controller;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class World {
	
	@Id @GeneratedValue(strategy=IDENTITY)
	private int id;
	
	private int randomNumber;
	
	public World() {}
	
	public World(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	public long getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}