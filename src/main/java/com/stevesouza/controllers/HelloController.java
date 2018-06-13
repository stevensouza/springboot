package com.stevesouza.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stevesouza.AppProps;
import com.stevesouza.db.Person;


@RestController
@RequestMapping("/restapi")
public class HelloController {

		@Autowired
		private AppProps props;
		
		@Autowired
		private PersonRepository personTableRepository;
		
	    @GetMapping()
	    public Iterable<Person> index() {
	    	Person justSaved=personTableRepository.save(new Person("Steven", "Souza"));
	    	System.out.println("***********"+justSaved);

	    	List<Person> people=new ArrayList<Person>();
	    	people.add(new Person("Joe", "Souza"));
	    	people.add(new Person("Winnie", "Souza"));
	    	people.add(new Person("Sandra", "Souza"));
	    	people.add(new Person("Jean", "Souza"));
	    	people.add(new Person("Joel", "Souza"));
	    	people.add(new Person("Steven", "Souza"));
	        return people;
	    }
	    
	    @GetMapping("/person/{personId}")
	   // @RequestMapping(value = "/person", method = RequestMethod.GET, produces = {"application/json"})
	    public Person person(@PathVariable("personId") String personId) {
	        return new Person(personId, props.getName());
	    }
	    

}
