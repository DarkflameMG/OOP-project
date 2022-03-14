package com.carin.carinProject.classes.Units;

import com.carin.carinProject.classes.ConfigImp;
import com.carin.carinProject.classes.FieldImp;
import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;

public class AntibodyFactory {
    private static AntibodyFactory instance;

    private AntibodyFactory(){}

    public static AntibodyFactory getInstance()
    {
        if (instance == null)
            instance = new AntibodyFactory();
        return instance;
    }
    public void newAntibody(String species,int x,int y) throws SyntaxError, TokenizerError
    {
        AntiBodyImp unit = new AntiBodyImp(species,x,y);
        FieldImp.getInstance(ConfigImp.getM(),ConfigImp.getN()).placeUnit(x,y,unit);
        UnitCollection.getInstance().addUnit(unit);
    }
}
