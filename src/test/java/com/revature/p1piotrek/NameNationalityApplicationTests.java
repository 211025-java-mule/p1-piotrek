package com.revature.p1piotrek;

import com.revature.p1piotrek.model.Person;
import com.revature.p1piotrek.util.PersonRepository;
import com.revature.p1piotrek.util.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NameNationalityApplicationTests {
    @Autowired
    PersonRepository personRepository;

	@Autowired
	PersonService personService;

    @Test
    public void testAddingPersonToRepository() {
        Person person = new Person();
        person.setName("Piotrek");
        person.setCountries("PL, ES");
        personRepository.save(person);
		int id = person.getId();

		Assertions.assertEquals(personRepository.findById(id).get(), person);
    }

    @Test
    public void testDeletingPersonToRepository() {
        Person person = new Person();
        person.setName("Pawel");
        person.setCountries("ES, AU");
        personRepository.save(person);
        personRepository.delete(person);

		long count = personRepository.count();

		Assertions.assertEquals(0, count);
	}

	@Test
	public void testNameGettingPersonFromGlobalAPI(){
		Person person = personService.savePersonFromGlobalAPI("Piotr");
		Assertions.assertEquals("Piotr" , person.getName());
	}
	@Test
	public void testCountriesGettingPersonFromGlobalAPI(){
		Person person = personService.savePersonFromGlobalAPI("Pawel");
		String countries = "[{\"country_id\":\"PL\",\"probability\":0.3468221788928576},{\"country_id\":\"IE\",\"probability\":0.22488776100317076},{\"country_id\":\"IS\",\"probability\":0.10871806244178477}]";
		Assertions.assertEquals(countries , person.getCountries());
	}
}


