package com.example;

import java.util.List;

public class Animal {

    public String getFamily() {
        return "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    }

    public List<String> getFood(String type) throws Exception {
        if ("Хищник".equals(type)) {
            return List.of("Животные", "Птицы", "Рыба");
        } else if ("Травоядное".equals(type)) {
            return List.of("Трава", "Различные растения");
        } else {
            throw new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }
}