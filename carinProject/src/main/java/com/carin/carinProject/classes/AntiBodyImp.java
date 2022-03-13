package com.carin.carinProject.classes;

import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import com.carin.carinProject.interfaces.AntiBodyUnit;
import com.carin.carinProject.interfaces.Unit;


public class AntiBodyImp extends UnitImp implements AntiBodyUnit {
    private int hp_gain = ConfigImp.getAntibody_gain();

    public AntiBodyImp(String species,int x,int y) throws SyntaxError, TokenizerError
    {
        super("antibody",species,x,y);
        if(species.equals("Momotaros"))
            hp_gain*=1.2;
    }

    @Override
    public void transform(String species) throws TokenizerError, SyntaxError
    {
//        field.removeUnit(coordinateX,coordinateY);
        UnitCollection allU = UnitCollection.getInstance();
        Unit newV = VirusFactory.getInstance().newVirus(species,coordinateX,coordinateY);
        allU.addUnit(newV);
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
                    if(target.isVirus() > 0)
                    {
                        return ((i*10)+direction);
                    }
                }
            }
        }
        return 0;
    }

    public void recovery()
    {
        hp += hp_gain;
    }

    @Override
    public void attack(int direction)
    {
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
            if(target.getHp() == 0)
            {
                recovery();
            }
        }
    }
}
