package com.qkstrt.guice;

import java.util.HashSet;
import java.util.Set;

import com.google.api.server.spi.guice.GuiceSystemServiceServletModule;
import com.googlecode.objectify.ObjectifyService;
import com.qkstrt.dao.ButtonDao;
import com.qkstrt.dao.IButtonDao;
import com.qkstrt.rest.api.ButtonsAPI;
import com.qkstrt.service.ButtonService;
import com.qkstrt.service.IButtonService;
import com.qkstrt.service.models.Button;

public class GoogleCloudEndpointsModule extends GuiceSystemServiceServletModule {

	@Override
	protected void configureServlets() {
		super.configureServlets();
		
		ObjectifyService.register(Button.class);
		
		this.bind(IButtonService.class).to(ButtonService.class)
				.asEagerSingleton();

		this.bind(IButtonDao.class).to(ButtonDao.class).asEagerSingleton();

		// Add API classes
		Set<Class<?>> serviceClasses = new HashSet<Class<?>>();
		serviceClasses.add(ButtonsAPI.class);

		this.serveGuiceSystemServiceServlet("/_ah/spi/*", serviceClasses);
	}
}
