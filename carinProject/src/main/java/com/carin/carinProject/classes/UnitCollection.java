package com.carin.carinProject.classes;

import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import com.carin.carinProject.interfaces.Unit;

import java.util.HashSet;
import java.util.Set;

public class UnitCollection {
    private static UnitCollection instance;
    private Set<Unit> allUnit;

    private UnitCollection()
    {
        allUnit = new HashSet<>();
    }

    public static UnitCollection getInstance()
    {
        if(instance == null)
            instance = new UnitCollection();
        return instance;
    }

    public void addUnit(Unit unit)
    {
        allUnit.add(unit);
    }

    public void removeUnit(Unit unit)
    {
        allUnit.remove(unit);
    }

    public void UnitRun()throws SyntaxError, TokenizerError
    {
        for(Unit unit: allUnit)
        {
            unit.run();
        }
    }
}
