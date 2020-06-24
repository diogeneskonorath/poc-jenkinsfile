package com.restService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void messageDefaultTest() throws Exception{
        this.mockMvc.perform(get("/message")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Olá, Mundo!"));
    }

    @Test
    public void olaAmigosMessageTest() throws Exception {
        this.mockMvc.perform(get("/message").param("name", "Amigos"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Olá, Amigos!"));
    }
}