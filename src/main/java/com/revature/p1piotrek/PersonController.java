package com.revature.p1piotrek;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/piotrek")
    public Person getPiotr() throws IOException {

        return personService.getPerson("Piotrek");
    }
    @GetMapping("/pawel")
    public Person getPawel() throws IOException {

        return personService.getPerson("Pawel");
    }



}