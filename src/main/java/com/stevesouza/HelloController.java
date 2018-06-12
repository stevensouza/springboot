package com.stevesouza;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/restapi")
public class HelloController {

		@Autowired
		private AppProps props;
		
	    @RequestMapping()
	    public List<Person> index() {
	    	List<Person> people=new ArrayList<Person>();
	    	people.add(new Person("Joe", "Souza"));
	    	people.add(new Person("Winnie", "Souza"));
	    	people.add(new Person("Sandra", "Souza"));
	    	people.add(new Person("Jean", "Souza"));
	    	people.add(new Person("Joel", "Souza"));
	    	people.add(new Person("Steven", "Souza"));
	        return people;
	    }
	    
	    @RequestMapping("/person/{personId}")
	   // @RequestMapping(value = "/person", method = RequestMethod.GET, produces = {"application/json"})
	    public Person person(@PathVariable("personId") String personId) {
	        return new Person(personId, props.getName());
	    }
	    

}
