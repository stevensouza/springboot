package com.stevesouza;

import javax.xml.bind.annotation.XmlRootElement;

// not needed if jackson is used for returning xml
@XmlRootElement
public class Person {
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	private String firstName;
	private String lastName;
	
	
}
