package com.carin.carinProject.classes.Units;

import com.carin.carinProject.GameDataService;
import com.carin.carinProject.classes.*;
import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import com.carin.carinProject.interfaces.Unit;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UnitCollection {
    private static UnitCollection instance;
    private Map<Unit,Unit> allUnit;
    private UnitData data = UnitData.getInstance();
    private  FieldImp field = FieldImp.getInstance(ConfigImp.getM(),ConfigImp.getN());

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

    public void newCollection()
    {
        allUnit = new ConcurrentHashMap<>();
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
        data.newList();
        for(Map.Entry<Unit,Unit> unit : allUnit.entrySet())
        {
            data.addXYT(unit.getValue().getCoordinateX(),unit.getValue().getCoordinateY(),unit.getValue().getSpecies());
            data.addHp(unit.getValue().getHp());
            unit.getValue().run();
        }
        GameData g = new GameData(field.getNum_virus(), field.getNum_antibody(), Credit.getInstance().current_credit(),null,data.getPosX(),
                data.getPosY(),data.getHp(),null,data.getType());
        GameDataService.setGameData(g);
    }

    public Set<Unit> getAllUnit()
    {
        return allUnit.keySet();
    }
}
