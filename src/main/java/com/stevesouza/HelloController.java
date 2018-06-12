package com.stevesouza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi")
public class HelloController {

		@Autowired
		private AppProps props;
		
	    @RequestMapping()
	    public String index() {
	        return "Greetings from Spring Boot and Steve!";
	    }
	    
	    @RequestMapping("/person")
	   // @RequestMapping(value = "/person", method = RequestMethod.GET, produces = {"application/json"})
	    public Person person() {
	        return new Person("Steve", props.getName());
	    }

}
