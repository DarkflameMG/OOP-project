package com.carin.carinProject.classes.parse;

import java.util.Random;

public class RandomNumber{
    private static RandomNumber instance;
    private final Random rand;

    private RandomNumber()
    {
        rand = new Random();
    }

    public static RandomNumber getInstance()
    {
        if(instance == null)
        {
            instance = new RandomNumber();
        }
        return instance;
    }

    public int RandNum()
    {
        return rand.nextInt(1000);
    }
}