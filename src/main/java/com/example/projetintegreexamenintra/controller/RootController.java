package com.example.projetintegreexamenintra.controller;

import com.example.projetintegreexamenintra.DTO.AnswerInDTO;
import com.example.projetintegreexamenintra.DTO.AnswerOutDTO;
import com.example.projetintegreexamenintra.exception.NoneAcceptableArgumentException;
import com.example.projetintegreexamenintra.service.CalculatorService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/")
public class RootController {
    private final Logger logger = LogManager.getLogger(RootController.class);
    private final CalculatorService calculatorService;

    @PostMapping("/additionCalcul")
    public ResponseEntity<AnswerOutDTO> additionCalculator(@RequestBody AnswerInDTO answer){
        logger.log(Level.INFO, "Post /additionCalcul entered with AnswerInDTO: " + answer);

        try {
            logger.log(Level.INFO, "Post /additionCalcul return request 200");
            AnswerOutDTO dto = calculatorService.additionCalculator(answer);
            return ResponseEntity.ok(dto);
        } catch (NoneAcceptableArgumentException e) {
            logger.log(Level.INFO, "Post /additionCalcul return request 409");
            return ResponseEntity.status(CONFLICT).build();
        }
    }

    @PostMapping("/soustractionCalcul")
    public ResponseEntity<AnswerOutDTO> soustractionCalculator(@RequestBody AnswerInDTO answer){
        logger.log(Level.INFO, "Post /soustractionCalcul entered with AnswerInDTO: " + answer);

        try {
            logger.log(Level.INFO, "Post /soustractionCalcul return request 200");
            AnswerOutDTO dto = calculatorService.soustractionCalculator(answer);
            return ResponseEntity.ok(dto);
        } catch (NoneAcceptableArgumentException e) {
            logger.log(Level.INFO, "Post /soustractionCalcul return request 409");
            return ResponseEntity.status(CONFLICT).build();
        }
    }
}
