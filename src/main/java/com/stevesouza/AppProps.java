package com.stevesouza;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/** 
 * Note by using a file is created that creates a json file that documents all
 * properties in the app.
 * 
 * mvn artifact to do this: <artifactId>spring-boot-configuration-processor</artifactId>
 * 
 * target\classes\META-INF\spring-configuration-metadata.json
 *  
 * @author stevesouza
 *
 */
@Component // makes it a spring bean
@ConfigurationProperties("myprops") // put on any class or method you want to populate with properties
public class AppProps {
	/** it looks for myprops.name from any of the valid locations for spring boot.
	  * i put the value in application.properties. Note it just looks for the variable
	  *  name and populates it. cool.
	  *  
	  *  Note also this comment will appear in the json file created for app constants mentioned above
	  */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
