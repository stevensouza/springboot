package com.stevesouza.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stevesouza.AppProps;
import com.stevesouza.db.Person;
import com.stevesouza.db.PersonRepository;

// try 1) different path commands 2) DELETE, PUT, POST

@RestController
@RequestMapping("/restapi")
public class HelloController {

    	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    	
		@Autowired
		private AppProps props;
		
		@Autowired
		private PersonRepository personTableRepository;

		
		// return all people
	    @GetMapping("/people")
	    public Iterable<Person> getPeople() {
	    	logger.info("just demonstrating property loaded from application.properties. myprops.name="+props.getName());;
	    	return personTableRepository.findAll();
	    }
	    
	    // Create a person
	    @PostMapping("/person")
	    public Person createPerson(Person person) {
	        return personTableRepository.save(person);
	    }
	    
	    // get a person by Id
	    @GetMapping("/person/{id}")
	    public Person getPerson(@PathVariable("id") long id) {
	    	 return personTableRepository.findById(id).orElseThrow(() -> new RuntimeException("personId="+id+" - not found"));
	    }
	    
	    // Update a person
	    @PutMapping("/person/{id}")
	    public Person updateNote(@PathVariable("id") long id, @RequestBody Person updatePerson) {	
	        Person existingPerson = getPerson(id);
	        
	        existingPerson.setFirstName(updatePerson.getFirstName());
	        existingPerson.setLastName(updatePerson.getLastName());
	        
	        return createPerson(existingPerson);
	     }
	    
	    // Delete a person
	    @DeleteMapping("/person/{id}")
	    public ResponseEntity<?> deletePerson(@PathVariable("id") long id) {
	    	Person person = getPerson(id);
	    	personTableRepository.delete(person);
	        return ResponseEntity.noContent().build();
	    }
	    
	    // get person(s) by lastName
	    @GetMapping("/person/bylastname/{lastName}")
	    public List<Person> getPerson(@PathVariable("lastName") String lastName) {
	    	 return personTableRepository.findByLastName(lastName);
	    }

}
