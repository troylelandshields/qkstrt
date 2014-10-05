package com.qkstrt.service;

import java.util.List;

import javax.inject.Inject;

import com.qkstrt.dao.IButtonDao;
import com.qkstrt.service.models.Button;

public class ButtonService implements IButtonService {

	IButtonDao buttonDao;
	
	@Inject
	public ButtonService(IButtonDao buttonDao) {
		this.buttonDao = buttonDao;
	}

	@Override
	public Button newButton(String name) {

		List<Button> buttons = buttonDao.listAll();

		while(buttons.size() > 14) {
			buttonDao.deleteButton(buttons.get(buttons.size()-1));
			buttons.remove(buttons.size()-1);
		}
		
		Button b = new Button();
		b.setName(name);
		
		return buttonDao.insertButton(b);
	}

	@Override
	public List<Button> listAll() {
		return buttonDao.listAll();
	}
	
	@Override
	public Button clickButton(Long id) {
		return buttonDao.clickButton(id);
	}

}
