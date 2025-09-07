package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CatTest {

    private Feline mockFeline;
    private Cat cat;

    @BeforeEach
    void setUp() {
        mockFeline = mock(Feline.class);
        cat = new Cat(mockFeline);
    }

    @Test
    void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetKittens() {
        when(mockFeline.getKittens()).thenReturn(1);

        assertEquals(1, cat.getKittens());

        verify(mockFeline, times(1)).getKittens();
    }

    @Test
    void testGetFood() throws Exception {

        List<String> expectedFood = List.of("Рыба", "Птицы");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);

        verify(mockFeline, times(1)).eatMeat();
    }
}