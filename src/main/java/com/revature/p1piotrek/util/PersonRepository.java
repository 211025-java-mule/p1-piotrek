package com.revature.p1piotrek.util;

import com.revature.p1piotrek.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
