package com.revature.p1piotrek;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Component
public class PersonService {

    private ObjectMapper objectMapper; // why is this working?
    private Person person;


    @Autowired
    public PersonService(ObjectMapper objectMapper, Person person) {
        this.objectMapper = objectMapper;
        this.person = person;

    }

    public Person getPerson(String inputName) throws IOException {
        URL url = new URL("https://api.nationalize.io/?name=" + inputName);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream response = connection.getInputStream();
        String body = new String(response.readAllBytes());

        person = new Person();
        JsonNode nameNode = objectMapper.readTree(body).path("name");
        String name = nameNode.toString().replace("\"", "");
        JsonNode countryNode = objectMapper.readTree(body).path("country");
        String listOfCountries = countryNode.toString();
        List<Country> countryList;
        countryList = objectMapper.readValue(listOfCountries, new TypeReference<>() {
        });
        person.setName(name);
        person.setCountries(countryList);

        return person;
    }
}
