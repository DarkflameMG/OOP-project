package classes;

import interfaces.Unit;

public class MainGame {
    private int MoveCost = ConfigImp.getAntibody_moveCost();

    public void moveAntibody(Unit target)
    {
        target.decreaseHp(MoveCost);
    }
}
