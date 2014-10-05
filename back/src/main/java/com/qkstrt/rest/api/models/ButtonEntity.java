package com.qkstrt.rest.api.models;

import com.qkstrt.service.models.Button;

public class ButtonEntity {
	
	private Long id;
	private String name;
	private double timesClicked;
	
	public ButtonEntity(Button h)
	{
		this.id = h.getId();
		this.name = h.getName();
		this.timesClicked = h.getTimesClicked();
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
