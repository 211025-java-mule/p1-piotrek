package com.revature.p1piotrek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;


    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    public Person getPersonById(int id) {
        return  personRepository.findById(id).get();
    }

    public void saveOrUpdate(Person person) {
        personRepository.save(person);
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }
}
