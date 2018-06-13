package com.stevesouza.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

// not needed if jackson is used for returning xml

@Entity
@XmlRootElement
public class Person {
	// primary key
	@Id
	@GeneratedValue // defaults to AUTO which picks the best strategy for the given db
	private long id;	
	
	// note getters/setters aren't required for jpa
	private String firstName;
	private String lastName;
	
	// a default constructor is required by jpa (i believe)
	protected Person() {}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
}
