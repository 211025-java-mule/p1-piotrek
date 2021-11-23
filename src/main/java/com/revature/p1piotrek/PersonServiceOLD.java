package com.revature.p1piotrek;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class PersonServiceOLD {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL("https://api.nationalize.io/?name=" + "asia");
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

        System.out.println(person);
    }

}




