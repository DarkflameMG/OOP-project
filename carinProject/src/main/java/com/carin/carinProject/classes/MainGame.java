package com.carin.carinProject.classes;

import com.carin.carinProject.interfaces.Unit;

public class MainGame {
    private int MoveCost = ConfigImp.getAntibody_moveCost();
    private double spawnRate = ConfigImp.getVirusSpawn();
    private FieldImp field = FieldImp.getInstance(ConfigImp.getM(),ConfigImp.getN());
    private static MainGame instance;
    private int game_speed = 1;
    private int game_start = 0;

    private MainGame(){}

    public static MainGame getInstance()
    {
        if(instance == null)
        {
            instance = new MainGame();
        }
        return instance;
    }

    public void setGame_speed(int speed)
    {
        game_speed = speed;
    }

    public int getGame_speed()
    {
        return game_speed;
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

    public void VirusSpawn()
    {

    }
}
