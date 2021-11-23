package com.revature.p1piotrek;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


@RestController
public class PersonController {
//    @Autowired
//    PersonServiceOLD personServiceOLD;

//    @GetMapping("/person/{name}")
//    public Person getPersonByName(@PathVariable String name) throws IOException {
//
//        return personServiceOLD.getPerson(name);
//    }

    @Autowired
    PersonService personService;

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
    private int savePersonWithName(@PathVariable("name") String inputName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL("https://api.nationalize.io/?name=" + inputName);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream response = connection.getInputStream();
        String body = new String(response.readAllBytes());

        Person person = new Person();
        JsonNode nameNode = objectMapper.readTree(body).path("name");
        String name = nameNode.toString().replace("\"", "");
        JsonNode countryNode = objectMapper.readTree(body).path("country");
        String listOfCountries = countryNode.toString();
        person.setName(name);
        person.setCountries(listOfCountries);


        personService.saveOrUpdate(person);
        return person.getId();
    }

}