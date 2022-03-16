package com.carin.carinProject.classes.Units;

import com.carin.carinProject.classes.Credit;
import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import com.carin.carinProject.interfaces.Unit;

public class HealerAntibody extends AntiBodyImp{

    public HealerAntibody(String species,int x,int y) throws SyntaxError, TokenizerError {
        super(species, x, y);
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
            if(target.isVirus() > 0)
                target.decreaseHp(damage);
            else
            {
                int heal = (damage*-1)/100;
                target.decreaseHp(heal);
            }
            if(target.getHp() == 0)
            {
                recovery();
                Credit.getInstance().CreditGain();
            }
        }
    }
}
