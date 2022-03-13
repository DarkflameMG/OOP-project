package com.carin.carinProject.classes;

import com.carin.carinProject.classes.Units.VirusFactory;
import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import com.carin.carinProject.interfaces.Unit;

import java.util.Random;

public class MainGame {
    private int MoveCost = ConfigImp.getAntibody_moveCost();
    private double spawnRate = ConfigImp.getVirusSpawn();
    private FieldImp field = FieldImp.getInstance(ConfigImp.getM(),ConfigImp.getN());
    private static MainGame instance;
    private int game_speed = 1;
    private int game_start = 0;
    private final Random rand;

    private MainGame()
    {
        rand = new Random();
    }

    public static MainGame getInstance()
    {
        if(instance == null)
        {
            instance = new MainGame();
        }
        return instance;
    }

    public void increaseGame_speed()
    {
        if(game_speed < 3)
            game_speed++;
    }

    public void decreaseGame_speed()
    {
        if(game_speed > 0)
            game_speed--;
    }

    public int getGame_speed()
    {
        return game_speed;
    }

    public int current_speedTime()
    {
        if(game_speed <= 1 )
            return 500;
        else if(game_speed == 2)
            return 250;
        else
            return 100;
    }

    public void setGame_start()
    {
        game_start = 1;
    }
    public int getGame_start()
    {
        return game_start;
    }

    public void moveAntibody(Unit target)
    {
        target.decreaseHp(MoveCost);
    }

    public void VirusSpawn() throws SyntaxError, TokenizerError
    {
        float num = rand.nextFloat(10)/10;
        System.out.println(num);
        if(num < spawnRate)
        {
            String s;
            int m = ConfigImp.getM();
            int n = ConfigImp.getN();
            int sp = rand.nextInt(3)%3;
            int x = rand.nextInt(m);
            int y = rand.nextInt(n);
            System.out.println("x : "+x);
            System.out.println("y : "+y);
            while (field.isEmpty(x,y) == 0)
            {
                x = rand.nextInt(m);
                y = rand.nextInt(n);
            }
            if(sp == 0)
                s = "Mimi";
            else if(sp == 1)
                s = "Karon";
            else
                s = "Abnormal";
            VirusFactory.getInstance().newVirus(s,x,y);
        }
    }
}
