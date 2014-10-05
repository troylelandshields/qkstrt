package com.qkstrt.service;

import java.util.List;

import com.qkstrt.service.models.Button;

public interface IButtonService {

	public Button newButton(String name);

	public List<Button> listAll();

	public Button clickButton(Long id);

}
