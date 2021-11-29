package com.revature.p1piotrek.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.p1piotrek.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class PersonController {
    @Autowired
    PersonService personService;
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    PersonRepository personRepository;

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
     *
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
        boolean ispresent = false;

        Iterable<Person> all = personRepository.findAll();
        Person person = personService.getPersonFromNationalizeIo(inputName);
        for (Person person1 : all) {
            if (person1.getName().equals(inputName)) {
                ispresent = true;
                break;
            }
        }
        if (ispresent) {
            return "This name is already in DB";
        } else {
            personService.saveOrUpdate(person);
            return "Person added with id: " + person.getId();
        }
    }

    /**
     * @param name Method checks if name is already present in Repository
     * @return Method returns true or false
     */

    @GetMapping("/persons/checkIfNameIPresent/{name}")
    public boolean checkIfNameIsPresent(@PathVariable("name") String name) {
        return personService.checkIfNameIsPresentInRepo(name);
    }

    /**
     * Method returns object of Person class by searching for its name
     * @param name String name is passed in this method
     * @return If person by input name is found it is returned. If not person with nulls is returned
     */
    @GetMapping("/person/{name}")
    public Person getPersonByName(@PathVariable("name") String name) {
        Iterable<Person> all = personRepository.findAll();
        Person person = new Person();
        for (Person person1 : all) {
            if (person1.getName().equals(name)) {
                person = person1;
                break;
            }
        }
        return person;
    }
}
