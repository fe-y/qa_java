package com.example;

import java.util.List;

public class Cat {

    private final Feline feline;

<<<<<<< HEAD
    public Cat(Feline feline) {
        this.feline = feline;
=======
    public Cat(Predator predator) {
        this.predator = predator;
>>>>>>> 17ac5c7 (Sprint_6)
    }

    public String getSound() {
        return "Мяу";
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public List<String> getFood() throws Exception {
        return feline.eatMeat();
    }
}