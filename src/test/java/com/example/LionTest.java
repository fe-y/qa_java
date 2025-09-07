package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LionTest {

    private Feline mockFeline;

    @BeforeEach
    void setUp() {
        mockFeline = Mockito.mock(Feline.class);
    }

    @Test
    void testDoesHaveManeMale() throws Exception {
        Lion male = new Lion("Самец", mockFeline);
        assertTrue(male.doesHaveMane());
    }

    @Test
    void testDoesHaveManeFemale() throws Exception {
        Lion female = new Lion("Самка", mockFeline);
        assertFalse(female.doesHaveMane());
    }

    @Test
    void testGetKittens() throws Exception {
        when(mockFeline.getKittens()).thenReturn(2);
        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(2, lion.getKittens());
        verify(mockFeline, times(1)).getKittens();
    }

    @Test
    void testGetFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expected);

        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(expected, lion.getFood());
        verify(mockFeline, times(1)).eatMeat();
    }

    @Test
    void testInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", mockFeline);
        });
        assertEquals("Используйте допустимые значения пола животного - Самец или Самка", exception.getMessage());
    }

}