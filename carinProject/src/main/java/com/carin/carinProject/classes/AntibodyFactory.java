package com.carin.carinProject.classes;

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
    public AntiBodyImp newAntibody(String species,int x,int y) throws SyntaxError, TokenizerError
    {
        AntiBodyImp unit = new AntiBodyImp(species,x,y);
        FieldImp.getInstance(ConfigImp.getM(),ConfigImp.getN()).placeUnit(x,y,unit);
        UnitCollection.getInstance().addUnit(unit);
        return unit;
    }
}
