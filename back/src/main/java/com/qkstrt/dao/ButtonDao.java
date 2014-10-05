package com.qkstrt.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Work;
import com.qkstrt.service.models.Button;

public class ButtonDao implements IButtonDao {

	@Override
	public Button insertButton(Button button) {
		ofy().save().entity(button).now();
		return button;
	}

	@Override
	public List<Button> listAll() {
		ofy().clear();
		List<Button> buttons = ofy().load().type(Button.class).order("-timesClicked").list();
		return buttons;
	}

	@Override
	public Button readButton(Long id) {
		return ofy().load().key(Key.create(Button.class, id)).now();
	}

	@Override
	public void deleteButton(Button b) {
		ofy().delete().entity(b).now();
	}

	@Override
	public Button clickButton(final Long id) {
		ofy().transact(new Work<Button>() {
			public Button run() {
				Button b = ofy().load().key(Key.create(Button.class, id)).now();
				b.click();
				ofy().save().entity(b);
				return b;
			}
		});

		return this.readButton(id);
	}
}
