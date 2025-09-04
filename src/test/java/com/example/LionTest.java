package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test
    public void getFoodUsesFelineMock() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самец", felineMock);
        List<String> food = lion.getFood();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        verify(felineMock, times(1)).eatMeat();
    }

    @Test
    public void getKittensReturnsCorrectNumber() {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(1, lion.getKittens());
    }

    @ParameterizedTest
    @CsvSource({
            "3, false",
            "4, true",
            "7, true"
    })
    public void doesHaveManeReturnsCorrectly(int age, boolean expected) {
        Feline felineMock = null;
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(expected, lion.doesHaveMane(age));
    }
}

