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
        // Создаем мок Feline
        mockFeline = mock(Feline.class);
        // Передаем мок в Cat
        cat = new Cat(mockFeline);
    }

    @Test
    void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetKittens() {
        when(mockFeline.getKittens()).thenReturn(1); // обязательно для мока
        assertEquals(1, cat.getKittens());
        verify(mockFeline, times(1)).getKittens();
    }

    @Test
    void testGetFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expected); // обязательно для мока

        List<String> actual = cat.getFood();
        assertEquals(expected, actual);
        verify(mockFeline, times(1)).eatMeat();
    }
}