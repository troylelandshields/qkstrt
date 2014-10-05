package com.qkstrt.rest.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;
import com.qkstrt.rest.api.models.ButtonEntity;
import com.qkstrt.rest.utilities.Constants;
import com.qkstrt.service.IButtonService;
import com.qkstrt.service.models.Button;

@Api(name = "buttons", version = "v1",
    scopes = { Constants.EMAIL_SCOPE },
    clientIds = { Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID,
        Constants.IOS_CLIENT_ID, com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID }, audiences = { Constants.ANDROID_AUDIENCE })
public class ButtonsAPI {

	  private static final Logger log = Logger
	      .getLogger(ButtonsAPI.class.getName());

	  @Inject
	  public ButtonsAPI(IButtonService buttonService) {
		  this.buttonService = buttonService;
	  }
	  
	  private IButtonService buttonService;

	  @ApiMethod(name = "newButton", httpMethod = HttpMethod.POST, path = "{name}")
	  public ButtonEntity newButton(@Named("name") String name)
	  {
		  log.fine(String.format("Request to create button with name %s", name));
		  return new ButtonEntity(buttonService.newButton(name));
	  }
	  
	  @ApiMethod(name = "list", httpMethod = HttpMethod.GET, path = "buttons")
	  public List<ButtonEntity> listButtons()
	  {
		  log.fine("Request to list all buttons");
		  List<ButtonEntity> result = new ArrayList<ButtonEntity>();
		  for(Button b : buttonService.listAll()) {
			  result.add(new ButtonEntity(b));
		  }
		  return result;
	  }
	  
	  @ApiMethod(name = "click", httpMethod = HttpMethod.PUT, path = "{id}")
	  public ButtonEntity clickButton(@Named("id") Long id)
	  {
		  log.fine(String.format("Request to click button with ID %d", id));
		  return new ButtonEntity(buttonService.clickButton(id));
	  }
}
