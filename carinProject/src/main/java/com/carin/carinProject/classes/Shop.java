package com.carin.carinProject.classes;

import com.carin.carinProject.classes.Units.AntiBodyImp;
import com.carin.carinProject.classes.Units.AntibodyFactory;
import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import com.carin.carinProject.interfaces.Unit;

public class Shop {
    private final int costA = ConfigImp.getAntibodyA_credit();
    private final int costB = ConfigImp.getAntibodyB_credit();
    private final int costC = ConfigImp.getAntibodyB_credit();
    private FieldImp field = FieldImp.getInstance(ConfigImp.getM(),ConfigImp.getN());
    private AntibodyFactory AFac = AntibodyFactory.getInstance();
    private int antibody_count = 0;
    private static Shop instance;

    private Shop(){}

    public static Shop getInstance()
    {
        if(instance == null)
            instance = new Shop();
        return instance;
    }

    public int getAntibody_count()
    {
        return antibody_count;
    }

    public void buy(String species,int x,int y) throws SyntaxError, TokenizerError
    {
        if(field.isEmpty(x,y) > 0)
        {
            antibody_count++;
           AFac.newAntibody(species,x,y);
            if(species.equals("PongPong"))
                Credit.getInstance().Buy(costA);
            else if(species.equals("Machina"))
                Credit.getInstance().Buy(costB);
            else
                Credit.getInstance().Buy(costC);
        }
        else
            System.out.println("can't place");
    }
}
