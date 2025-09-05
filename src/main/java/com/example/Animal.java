<<<<<<< HEAD
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
=======
package com.example;
import java.util.List;
public class Animal {

    public List<String> getFood(String animalKind) throws Exception {
        if ("Травоядное".equals(animalKind)) {
            return List.of("Трава", "Различные растения");
        } else if ("Хищник".equals(animalKind)) {
            return List.of("Животные", "Птицы", "Рыба");
        } else {
            throw new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }

    public String getFamily() {
        return "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    }
>>>>>>> 17ac5c7 (Sprint_6)
}