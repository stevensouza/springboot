package com.stevesouza.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stevesouza.AppProps;
import com.stevesouza.db.Person;
import com.stevesouza.db.PersonRepository;

// try 1) different path commands 2) DELETE, PUT, POST

@RestController
@RequestMapping("/restapi")
public class HelloController {

		@Autowired
		private AppProps props;
		
		@Autowired
		private PersonRepository personTableRepository;
		

	    // Get a Single Note

	    // Update a Note

	    // Delete a Note
		
		// return all people
	    @GetMapping("/people")
	    public Iterable<Person> index() {
	        return personTableRepository.findAll();
	    }
	    
	    // Create a person
	    @PostMapping("/person")
	    public Person createPerson(Person person) {
	        return personTableRepository.save(person);
	    }

	    
	    
	    
	    @GetMapping("/person/{personId}")
	   // @RequestMapping(value = "/person", method = RequestMethod.GET, produces = {"application/json"})
	    public Person person(@PathVariable("personId") String personId) {
	        return new Person(personId, props.getName());
	    }
	    

}
