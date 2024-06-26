package com.github.glo2003;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void whenEmptyString_thenReturnsZero() {
        int result = calculator.add("");

        assertEquals(0, result);
    }

    @Test
    void whenAddingOneNumber_shouldReturnSameNumber(){
        int result = calculator.add("1");
        assertEquals(1, result);
    }

    @Test
    void whenAddigMultipleNumbers_shouldReturnSum(){
        int result = calculator.add("1,2");
        assertEquals(3, result);
    }

    @Test
    void whenAddigMultipleNumbersWithSpace_shouldReturnSum(){
        int result = calculator.add("1, 2");
        assertEquals(3, result);
    }

    @Test
    void whenAddigMultipleNumbersWithNoEmptySpaceAfterComma_shouldReturnSum(){
        int result = calculator.add("1,");
        assertEquals(1, result);
    }
    @Test
    void whenAddigMultipleNumbersWithCommaAndEmptySpace_shouldReturnSum(){
        int result = calculator.add("1, ");
        assertEquals(1, result);
    }

    @Test
    void whenNonNumericValues_thenThrowInvalidInput() {
        assertThrows(InvalidNumberFormatException.class,
                () -> calculator.add("4,a"));
    }
}