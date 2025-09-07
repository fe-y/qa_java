package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LionTest {

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void doesHaveManeReturnsCorrectly(String sex, boolean expectedHasMane) throws Exception {
        Feline mockFeline = mock(Feline.class);
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    void testInvalidSexThrowsException() {
        Feline mockFeline = mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", mockFeline);
        });
        assertEquals("Используйте допустимые значения пола животного - Самец или Самка", exception.getMessage());
    }

    @Test
    void testGetKittens() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(1);

        Lion lion = new Lion("Самец", mockFeline);
        assertEquals(1, lion.getKittens());
        verify(mockFeline, times(1)).getKittens();
    }

    @Test
    void testGetFood() throws Exception {
        Feline mockFeline = mock(Feline.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", mockFeline);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
        verify(mockFeline, times(1)).eatMeat();
    }
}