package com.stevesouza;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component // makes it a spring bean
@ConfigurationProperties("myprops") // put on any class or method you want to populate with properties
public class AppProps {
	// it looks for myprops.name from any of the valid locations for spring boot.
	// i put the value in application.properties. Note it just looks for the variable
	// name and populates it. cool.
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
