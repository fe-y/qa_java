package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    @Test
    public void getKittensReturnsCorrectNumber() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getFoodHerbivoreReturnsList() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    public void getFoodPredatorReturnsList() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getFoodThrowsExceptionForUnknownKind() {
        Feline feline = new Feline();
        Exception exception = null;
        try {
            feline.getFood("Неизвестно");
        } catch (Exception e) {
            exception = e;
        }
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void eatMeatReturnsCorrectList() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}