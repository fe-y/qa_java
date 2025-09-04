package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LionParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "3, false",
            "4, true",
            "5, true",
            "7, true"
    })
    public void doesHaveManeReturnsCorrectly(int age, boolean expectedResult) {
        Feline felineMock = null;
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(expectedResult, lion.doesHaveMane(age));
    }
}
