package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FelineTest {

    private Feline feline;

    @BeforeEach
    public void setUp() {
        feline = new Feline();
    }


    @Test
    public void getKittensReturnsDefaultOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithArgumentReturnsCorrectNumber() {
        assertEquals(5, feline.getKittens(5));
        assertEquals(0, feline.getKittens(0));
    }


    @Test
    public void getFoodForHerbivoreReturnsCorrectList() throws Exception {
        List<String> food = feline.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    public void getFoodForPredatorReturnsCorrectList() throws Exception {
        List<String> food = feline.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getFoodThrowsExceptionForUnknownKind() {
        Exception exception = assertThrows(Exception.class, () -> feline.getFood("Неизвестно"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }


    @Test
    public void eatMeatReturnsPredatorFoodList() throws Exception {
        List<String> meat = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), meat);
    }


    @Test
    public void getFamilyReturnsCorrectFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }
}