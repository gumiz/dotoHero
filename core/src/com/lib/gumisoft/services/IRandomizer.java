package com.lib.gumisoft.services;

public interface IRandomizer {
    int getRandomNumber(int max);
    int getRandomNumber(int min, int max);
    boolean rollDice(int number);
}
