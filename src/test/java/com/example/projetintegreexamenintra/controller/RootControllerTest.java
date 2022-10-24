package com.example.projetintegreexamenintra.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class RootControllerTest {
    @InjectMocks
    private RootController rootController;
    private MockMvc mockMvc;


    @BeforeEach
    void beforeEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(rootController).build();
        JacksonTester.initFields(this, new ObjectMapper());
    }
}
