package com.revature.p1piotrek.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.p1piotrek.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController {
    @Autowired
    PersonService personService;
    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/persons")
    private List<Person> getAllPersons() {
        return personService.findAll();
    }

    @GetMapping("/persons/{id}")
    private Person getPerson(@PathVariable("id") int id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping("/persons/{id}")
    private void deletePerson(@PathVariable("id") int id) {
        personService.delete(id);
    }

    @PostMapping("/persons")
    private int savePerson(@RequestBody Person person) {
        personService.saveOrUpdate(person);
        return person.getId();
    }

    @GetMapping("/persons/name/{name}")
    private String savePersonWithName(@PathVariable("name") String inputName) {
        Person person = personService.savePersonFromGlobalAPI(inputName);
        personService.saveOrUpdate(person);
        return "Person added with id: " + person.getId();
    }
}