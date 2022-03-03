package com.carin.carinProject.classes;

import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import com.carin.carinProject.interfaces.Unit;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UnitCollection {
    private static UnitCollection instance;
    private Map<Unit,Unit> allUnit;

    private UnitCollection()
    {
        allUnit = new ConcurrentHashMap<>();
    }

    public static UnitCollection getInstance()
    {
        if(instance == null)
            instance = new UnitCollection();
        return instance;
    }

    public void addUnit(Unit unit)
    {
        allUnit.put(unit,unit);
    }

    public void removeUnit(Unit unit)
    {
        allUnit.remove(unit);
    }

    public void UnitRun()throws SyntaxError, TokenizerError
    {
        for(Map.Entry<Unit,Unit> unit : allUnit.entrySet())
        {
            unit.getValue().run();
        }
    }
}
