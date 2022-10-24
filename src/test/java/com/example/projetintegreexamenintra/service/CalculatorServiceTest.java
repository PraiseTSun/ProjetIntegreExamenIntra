package com.example.projetintegreexamenintra.service;

import com.example.projetintegreexamenintra.DTO.AnswerInDTO;
import com.example.projetintegreexamenintra.DTO.AnswerOutDTO;
import com.example.projetintegreexamenintra.exception.NoneAcceptableArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.util.AssertionErrors.fail;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {
    @InjectMocks
    CalculatorService calculatorService;
    private AnswerInDTO answerIn;

    @BeforeEach
    void beforeEach(){
        answerIn = AnswerInDTO.builder()
                .number1("10")
                .number2("5")
                .build();
    }

    @Test
    void testAdditionCalculatorHappyDay() throws NoneAcceptableArgumentException {
        AnswerOutDTO dto = calculatorService.additionCalculator(answerIn);

        assertThat(dto.getAnswer()).isEqualTo(15);
    }

    @Test
    void testAdditionCalculatorConflict() {
        answerIn.setNumber1(null);

        try {
            calculatorService.additionCalculator(answerIn);
        } catch (NoneAcceptableArgumentException e) {
            return;
        }

        fail("Fail to catch the NoneAcceptableArgumentException");
    }

    @Test
    void testSoustractionCalculatorHappyDay() throws NoneAcceptableArgumentException {
        AnswerOutDTO dto = calculatorService.soustractionCalculator(answerIn);

        assertThat(dto.getAnswer()).isEqualTo(5);
    }

    @Test
    void testSoustractionCalculatorConflict() {
        answerIn.setNumber2(null);

        try {
            calculatorService.soustractionCalculator(answerIn);
        } catch (NoneAcceptableArgumentException e) {
            return;
        }

        fail("Fail to catch the NoneAcceptableArgumentException");
    }
}
