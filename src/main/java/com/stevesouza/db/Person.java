package com.stevesouza.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

// @XmlRootElement not needed if jackson is used for returning xml
// note json generation won't be default return values for private variables.  I added
// get methods and the data was returned. Originally id didn't have a get method and
// the other fields were returned, but id was not.

// note with spring data jpa a connection is automatically established with the 
// embedded h2 database. 
// try different column annotations

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
	
	public long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
