package com.carin.carinProject.classes;
import com.carin.carinProject.interfaces.Field;
import com.carin.carinProject.interfaces.Unit;


public class FieldImp implements Field {
    private static FieldImp instance;
    private Unit[][] slot;
    private int num_virus;
    private int num_antibody;

    private FieldImp(int m,int n)
    {
        slot = new Unit[n+1][m+1];
    }

    public static FieldImp getInstance(int m, int n)
    {
        if(instance == null)
        {
            instance = new FieldImp(n,m);
        }
        return instance;
    }

    public void placeUnit(int x, int y, Unit unit)
    {
        slot[y][x] = unit;
        if(unit.isAntiBody() > 0)
        {
            num_antibody++;
            if(num_antibody == 3)
                MainGame.getInstance().setGame_start();
        }
        else
            num_virus++;
    }

    public void removeUnit(int x, int y)
    {
        if(isEmpty(x,y)==0)
        {
            if(slot[y][x].isAntiBody() > 0)
                num_antibody--;
            else
                num_virus--;

            slot[y][x] = null;
        }
    }

    public int isEmpty(int x, int y)
    {
        if(slot[y][x] == null)
            return 1;
        return 0;
    }

    public Unit getTarget(int x, int y)
    {
        if(x < ConfigImp.getM() && y < ConfigImp.getN() && x >= 0 && y >= 0)
            return slot[y][x];
        return null;
    }

    public int getNum_virus()
    {
        return num_virus;
    }

    public int getNum_antibody()
    {
        return num_antibody;
    }
}
