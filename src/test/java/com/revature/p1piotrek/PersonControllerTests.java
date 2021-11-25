package com.revature.p1piotrek;

import com.revature.p1piotrek.util.PersonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTests {

    @Autowired
    PersonController personController;

    @Autowired
    MockMvc mockMvc;


    @Test
    public void testGetAllPersons() throws Exception {

        this.mockMvc
                .perform(get("/persons"))
                .andExpect(status().isOk());

    }

    @Test
    public void testSavePersonWithName() throws Exception {
        this.mockMvc
                .perform(get("/persons/name/pawel"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Person added with id: 1")));

    }
}




