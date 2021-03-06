package com.carin.carinProject.classes.Units;

import com.carin.carinProject.classes.ConfigImp;
import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import com.carin.carinProject.interfaces.VirusUnit;
import com.carin.carinProject.interfaces.Unit;

public class VirusImp extends UnitImp implements VirusUnit {
    private int hp_drain = ConfigImp.getVirus_gain();
    public VirusImp(String species,int x,int y)throws SyntaxError, TokenizerError
    {
        super("virus",species,x,y);
        if(species.equals("Abnormal"))
            hp_drain*=1.2;
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
                    y -= i;
                if(direction == 4 || direction == 5 || direction == 6)
                    y += i;
                if(direction == 2 || direction == 3 || direction == 4)
                    x += i;
                if(direction == 6 || direction == 7 || direction == 8)
                    x -= i;
                Unit target = field.getTarget(x,y);
                if(target != null)
                {
                    if(target.isAntiBody() > 0)
                    {
                        return ((i*10)+direction);
                    }
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
        try {
            int x = coordinateX,y = coordinateY;
            if(direction == 1 || direction == 2 || direction == 8)
                y -= 1;
            if(direction == 4 || direction == 5 || direction == 6)
                y += 1;
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
        catch (TokenizerError | SyntaxError e)
        {

        }
    }
}
