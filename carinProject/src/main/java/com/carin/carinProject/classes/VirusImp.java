package com.carin.carinProject.classes;

import com.carin.carinProject.interfaces.VirusUnit;
import com.carin.carinProject.interfaces.Unit;

public class VirusImp extends UnitImp implements VirusUnit {
    private final int hp_drain = ConfigImp.getVirus_gain();
    public VirusImp(String species)
    {
        super("virus",species,0,0);
    }

    public void spawn()
    {

    }

    public void drain()
    {
        hp+=hp_drain;
    }
    @Override
    public void attack(int direction)
    {
        FieldImp field = FieldImp.getInstance(10,10);
        int x = coordinateX,y = coordinateY;
        if(direction == 1 || direction == 2 || direction == 8)
            y += 1;
        if(direction == 4 || direction == 5 || direction == 6)
            y -= 1;
        if(direction == 2 || direction == 3 || direction == 4)
            x += 1;
        if(direction == 6 || direction == 7 || direction == 8)
            x -= 1;
        Unit target = field.getTarget(x,y);
        if(target != null)
        {
            target.decreaseHp(damage);
            drain();
            if (target.getHp() == 0)
                target.transform(species);
        }
    }
}
