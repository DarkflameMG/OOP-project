package main.java.com.carin.carinProject.classes;

import main.java.com.carin.carinProject.interfaces.Unit;

public class MainGame {
    private int MoveCost = ConfigImp.getAntibody_moveCost();

    public void moveAntibody(Unit target)
    {
        target.decreaseHp(MoveCost);
    }
}
