package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;

public class CatTest {

    private Feline feline;
    private Cat cat;

    @BeforeEach
<<<<<<< HEAD
    void setUp() {
=======
    public void setUp() {
>>>>>>> 17ac5c7 (Sprint_6)
        feline = mock(Feline.class);
        cat = new Cat(feline);
    }

    @Test
<<<<<<< HEAD
    void testGetSound() {
=======
    public void testGetSound() {
>>>>>>> 17ac5c7 (Sprint_6)
        assertEquals("Мяу", cat.getSound());
    }

    @Test
<<<<<<< HEAD
    void testGetKittens() {
        when(feline.getKittens()).thenReturn(1);
        assertEquals(1, cat.getKittens());
    }

    @Test
    void testGetFoodReturnsExpected() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();
        assertEquals(expected, actual);
    }

    @Test
    void testGetFoodInvokesEatMeatOnce() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        cat.getFood();
        verify(feline, times(1)).eatMeat();
=======
    public void testGetFood() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Мясо"));
        List<String> food = cat.getFood();
        assertEquals(List.of("Мясо"), food);
        verify(feline).eatMeat();
>>>>>>> 17ac5c7 (Sprint_6)
    }
}