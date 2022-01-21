package com.bkacad.nnt.simplemvcdemo.utils;

public final class Util {

    private Util(){};

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
