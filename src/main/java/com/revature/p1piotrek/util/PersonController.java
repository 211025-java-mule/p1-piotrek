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

    /**
     * @return Method returns all Person objects stored in PersonRepository
     */
    @GetMapping("/persons")
    private List<Person> getAllPersons() {
        return personService.findAll();
    }

    /**
     * @param id Method consumes 'id' in order to perform GET method for specific person
     * @return Method returns Person with 'id' that has been searched for
     */
    @GetMapping("/persons/{id}")
    private Person getPerson(@PathVariable("id") int id) {
        return personService.getPersonById(id);
    }

    /**
     * Method deletes person from PersonRepository
     * @param id Method consumes 'id' as a parameter to select object for deletion
     */
    @DeleteMapping("/persons/{id}")
    private void deletePerson(@PathVariable("id") int id) {
        personService.delete(id);
    }

    /**
     * @param inputName Method consumes String inputName which is used to perform GET method from external API
     * @return Method returns confirmation of adding object with its 'id'
     */
    @GetMapping("/persons/name/{name}")
    private String savePersonWithName(@PathVariable("name") String inputName) {
        Person person = personService.getPersonFromNationalizeIo(inputName);
        personService.saveOrUpdate(person);
        return "Person added with id: " + person.getId();
    }
}