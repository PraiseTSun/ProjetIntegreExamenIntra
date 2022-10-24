package com.example.projetintegreexamenintra.controller;

import com.example.projetintegreexamenintra.DTO.AnswerInDTO;
import com.example.projetintegreexamenintra.DTO.AnswerOutDTO;
import com.example.projetintegreexamenintra.exception.NoneAcceptableArgumentException;
import com.example.projetintegreexamenintra.service.CalculatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class RootControllerTest {
    @InjectMocks
    private RootController rootController;
    private MockMvc mockMvc;
    @Mock
    CalculatorService calculatorService;
    JacksonTester<AnswerInDTO> jsonAnswer;
    AnswerInDTO answerInDTO;
    @BeforeEach
    void beforeEach(){
        mockMvc = MockMvcBuilders.standaloneSetup(rootController).build();
        JacksonTester.initFields(this, new ObjectMapper());

        answerInDTO = AnswerInDTO.builder()
                .number1("10")
                .number2("5")
                .build();
    }

    @Test
    void testAdditionCalculatorHappyDay() throws Exception {
        when(calculatorService.additionCalculator(answerInDTO))
                .thenReturn(new AnswerOutDTO(15));

        mockMvc.perform(post("/additionCalcul")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAnswer.write(answerInDTO).getJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.answer", is(15)));
    }

    @Test
    void testAdditionCalculatorConflict() throws Exception {
        when(calculatorService.additionCalculator(any()))
                .thenThrow(new NoneAcceptableArgumentException());

        mockMvc.perform(post("/additionCalcul")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAnswer.write(answerInDTO).getJson()))
                .andExpect(status().isConflict());
    }

    @Test
    void testSoustractionCalculatorHappyDay() throws Exception {
        when(calculatorService.soustractionCalculator(answerInDTO))
                .thenReturn(new AnswerOutDTO(5));

        mockMvc.perform(post("/soustractionCalcul")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAnswer.write(answerInDTO).getJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.answer", is(5)));
    }

    @Test
    void testSoustractionCalculatorConflict() throws Exception {
        when(calculatorService.soustractionCalculator(any()))
                .thenThrow(new NoneAcceptableArgumentException());

        mockMvc.perform(post("/soustractionCalcul")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonAnswer.write(answerInDTO).getJson()))
                .andExpect(status().isConflict());
    }
}
