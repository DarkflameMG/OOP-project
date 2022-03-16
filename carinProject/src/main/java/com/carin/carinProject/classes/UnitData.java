package com.carin.carinProject.classes;

import java.util.ArrayList;
import java.util.List;

public class UnitData {
    private static UnitData instance;
    private List<Integer> posX = new ArrayList<>();
    private List<Integer> posY = new ArrayList<>();
    private List<Integer> Type = new ArrayList<>();

    private UnitData(){}

    public static UnitData getInstance()
    {
        if(instance == null)
            instance = new UnitData();
        return instance;
    }

    public void newList()
    {
        posX = new ArrayList<>();
        posY = new ArrayList<>();
        Type = new ArrayList<>();
    }

    public void addXYT(int x,int y,int t)
    {
        posX.add(x);
        posY.add(y);
        Type.add(t);
    }

    public List<Integer> getPosX()
    {
        return posX;
    }

    public List<Integer> getPosY()
    {
        return posY;
    }

    public List<Integer> getType()
    {
        return Type;
    }
}
