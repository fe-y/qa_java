package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class LionTest {

    private Feline feline;

    @BeforeEach
    void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Test
    void testDoesHaveManeMale() throws Exception {
        Lion male = new Lion("Самец", feline);
        assertTrue(male.doesHaveMane());
    }

    @Test
    void testDoesHaveManeFemale() throws Exception {
        Lion female = new Lion("Самка", feline);
        assertFalse(female.doesHaveMane());
    }

    @Test
    void testGetKittens() throws Exception {
        when(feline.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самец", feline);
        assertEquals(2, lion.getKittens());
    }

    @Test
    void testGetFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expected);

        Lion lion = new Lion("Самец", feline);
        assertEquals(expected, lion.getFood());
    }

    @Test
    void testInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", feline);
        });
        assertEquals("Используйте допустимые значения пола животного - Самец или Самка", exception.getMessage());
    }
}