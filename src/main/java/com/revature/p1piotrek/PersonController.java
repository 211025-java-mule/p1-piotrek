package com.revature.p1piotrek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/{name}")
    public Person getPersonByName(@PathVariable String name) throws IOException {

        return personService.getPerson(name);
    }
}