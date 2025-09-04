package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LionTest {

    @Test
    void doesHaveManeReturnsTrueForMale() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void doesHaveManeReturnsFalseForFemale() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void getFoodCallsFelineEatMeat() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", felineMock);
        List<String> food = lion.getFood();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        verify(felineMock, times(1)).eatMeat();
    }

    @Test
    void getKittensCallsFeline() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", felineMock);
        int kittens = lion.getKittens();

        assertEquals(3, kittens);
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    void constructorThrowsExceptionForInvalidSex() {
        Feline felineMock = mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неизвестно", felineMock));
        assertEquals("Используйте допустимые значения пола животного - Самец или Самка", exception.getMessage());
    }
}