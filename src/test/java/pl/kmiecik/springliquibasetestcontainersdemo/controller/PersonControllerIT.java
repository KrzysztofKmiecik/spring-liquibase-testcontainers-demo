package pl.kmiecik.springliquibasetestcontainersdemo.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
public class PersonControllerIT extends BaseIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPeople() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/persons"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)));
    }

}