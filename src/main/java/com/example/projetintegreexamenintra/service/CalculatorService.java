package com.example.projetintegreexamenintra.service;

import com.example.projetintegreexamenintra.DTO.AnswerInDTO;
import com.example.projetintegreexamenintra.DTO.AnswerOutDTO;
import com.example.projetintegreexamenintra.exception.NoneAcceptableArgumentException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CalculatorService {
    public AnswerOutDTO additionCalculator(AnswerInDTO dto) throws NoneAcceptableArgumentException {
        int number1 = getNumber(dto.getNumber1());
        int number2 = getNumber(dto.getNumber2());

        return new AnswerOutDTO(number1 + number2);
    }

    public AnswerOutDTO soustractionCalculator(AnswerInDTO dto) throws NoneAcceptableArgumentException {
        int number1 = getNumber(dto.getNumber1());
        int number2 = getNumber(dto.getNumber2());

        return new AnswerOutDTO(number1 - number2);
    }

    private int getNumber(String nb) throws NoneAcceptableArgumentException {
        try {
            return Integer.parseInt(nb);
        } catch(Exception e){
            throw new NoneAcceptableArgumentException();
        }
    }
}
