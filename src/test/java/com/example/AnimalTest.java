package com.example;

<<<<<<< HEAD
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class AnimalTest {

    private Animal animal;

    @BeforeEach
    void setUp() {
        animal = new Animal();
    }

    @Test
    void testGetFamily() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    void testGetFoodPredator() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = animal.getFood("Хищник");
        assertEquals(expected, actual);
    }

    @Test
    void testGetFoodHerbivore() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        List<String> actual = animal.getFood("Травоядное");
        assertEquals(expected, actual);
    }

    @Test
    void testGetFoodUnknown() {
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Неизвестное");
        });
        assertTrue(exception.getMessage().contains("Неизвестный вид животного"));
=======
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

    @Test
    public void testGetFoodHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, animal.getFood("Травоядное"));
    }

    @Test
    public void testGetFoodPredator() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, animal.getFood("Хищник"));
    }

    @Test
    public void testGetFoodUnknown() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> animal.getFood("Непонятно"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
>>>>>>> 17ac5c7 (Sprint_6)
    }
}