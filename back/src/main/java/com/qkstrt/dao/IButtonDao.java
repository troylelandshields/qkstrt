package com.qkstrt.dao;

import java.util.List;

import com.qkstrt.service.models.Button;

public interface IButtonDao {

	public Button insertButton(Button button);

	public List<Button> listAll();

	public Button readButton(Long id);

	public void deleteButton(Button b);

	public Button clickButton(Long id);

}
