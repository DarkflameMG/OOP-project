package com.carin.carinProject.classes;

import com.carin.carinProject.interfaces.Unit;

public class MainGame {
    private int MoveCost = ConfigImp.getAntibody_moveCost();
    private double spawnRate = ConfigImp.getVirusSpawn();
    private FieldImp field = FieldImp.getInstance(ConfigImp.getM(),ConfigImp.getN());

    public void moveAntibody(Unit target)
    {
        target.decreaseHp(MoveCost);
    }

    public void VirusSpawn()
    {

    }
}
