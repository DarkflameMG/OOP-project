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

    @Override
    public int Sensor()
    {
        int Max = Math.max(ConfigImp.getM(),ConfigImp.getN());
        for(int i=1;i<=Max;i++)
        {
            for(int direction = 1;direction <= 8;direction++)
            {
                int x = coordinateX,y = coordinateY;
                if(direction == 1 || direction == 2 || direction == 8)
                    y += i;
                if(direction == 4 || direction == 5 || direction == 6)
                    y -= i;
                if(direction == 2 || direction == 3 || direction == 4)
                    x += i;
                if(direction == 6 || direction == 7 || direction == 8)
                    x -= i;
                Unit target = field.getTarget(x,y);
                if(target != null)
                {
                    if(target.isAntiBody() > 0)
                        return (i*10)+direction;
                }
            }
        }
        return 0;
    }

    public void drain()
    {
        hp+=hp_drain;
    }

    @Override
    public void attack(int direction)
    {
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
