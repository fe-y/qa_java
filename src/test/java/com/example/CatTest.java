package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CatTest {

    @Test
    public void getSoundAlwaysMiau() {
        Feline felineMock = mock(Feline.class);
        Cat cat = new Cat(felineMock);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodUsesFelineMock() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.eatMeat()).thenReturn(List.of("Рыба", "Птицы"));

        Cat cat = new Cat(felineMock);
        List<String> food = cat.getFood();

        assertEquals(List.of("Рыба", "Птицы"), food);
        verify(felineMock, times(1)).eatMeat();
    }
}