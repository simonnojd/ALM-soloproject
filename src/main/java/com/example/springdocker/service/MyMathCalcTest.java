package com.example.springdocker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyMathCalcTest {
    private MyMathCalc myMathCalc;

    @BeforeEach
    public void init() throws Exception {
        myMathCalc = new MyMathCalc();
    }

    @Test
    @DisplayName("Simple addition should work")
    public void testAdd() {
        assertEquals(5, myMathCalc.add(3,2),
                "Regular addition should work");
    }

    @Test
    @DisplayName("Simple multiplication should work")
    public void testMultiply() {
        assertEquals(6, myMathCalc.multiply(3,2),
                "Regular multiplication should work");
    }

    @Test
    @DisplayName("Simple division should work")
    public void testDivision() {
        assertEquals(2, myMathCalc.divide(4,2),
                "Regular division should work");
    }

    @Test
    @DisplayName("Simple division should work")
    public void testDivisionWithZero() {
        Throwable exception = assertThrows(ArithmeticException.class, () -> myMathCalc.divide(1,0));
        assertEquals("/ by zero", exception.getMessage());
    }
}
