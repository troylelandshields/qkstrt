package com.qkstrt.service.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Button {

	public Button() {
	}

	public Button(Long id, String name, double timesClicked) {
		this.id = id;
		this.name = name;
		this.timesClicked = timesClicked;
	}

	@Id
	private Long id;
	private String name;
	@Index
	private double timesClicked;
	
	public void click() {
		this.timesClicked+=1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTimesClicked() {
		return timesClicked;
	}

	public void setTimesClicked(double timesClicked) {
		this.timesClicked = timesClicked;
	}

}
