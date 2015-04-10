package com.lib.gumisoft.services;

import java.util.Random;

public class Randomizer implements IRandomizer {
    private final Random _random;

    public Randomizer() {
        _random = new Random();
    }

    @Override
    public int getRandomNumber(int max) {
        int number = _random.nextInt(max);
        return number;
    }

    @Override
    public int getRandomNumber(int min, int max) {
        int number =  _random.nextInt((max - min) + 1) + min;
        return number;
    }

    @Override
    public boolean rollDice(int number) {
        int testNumber = _random.nextInt(number);
        return (testNumber == 0);
    }
}
