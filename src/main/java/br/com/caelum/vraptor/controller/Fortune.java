package br.com.caelum.vraptor.controller;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fortune implements Comparable<Fortune> {

	@Id @GeneratedValue(strategy=IDENTITY)
	private long id;
	
	private String message;

	public Fortune() {}
	
	public Fortune(String message) {
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int compareTo(Fortune other) {
		return message.compareTo(other.message);
	}
}
