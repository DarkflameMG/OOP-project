package com.carin.carinProject.classes;

import com.carin.carinProject.classes.Units.AntiBodyImp;
import com.carin.carinProject.classes.Units.AntibodyFactory;
import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;

public class Shop {
    private int cost = ConfigImp.getAntibody_placementCost();
    private FieldImp field = FieldImp.getInstance(ConfigImp.getM(),ConfigImp.getN());
    private AntibodyFactory AFac = AntibodyFactory.getInstance();

    public void buy(String species,int x,int y) throws SyntaxError, TokenizerError
    {
        AntiBodyImp Antibody = AFac.newAntibody(species,x,y);
        if(field.isEmpty(x,y) > 0)
            field.placeUnit(x,y,Antibody);
        else
            System.out.println("can't place");
    }
}
