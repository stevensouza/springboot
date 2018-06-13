package com.stevesouza.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// Try with different interfaces to generate queries
// try @Query annotation.
public interface PersonRepository extends CrudRepository<Person, Long> {

   public  List<Person> findByLastName(String lastName);

}
