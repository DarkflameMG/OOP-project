package classes;

import interfaces.Field;
import interfaces.Unit;

public class FieldImp implements Field {
    protected static FieldImp instance;
    protected Unit[][] slot;

    private FieldImp(int m,int n)
    {
        slot = new Unit[m][n];
    }

    public static FieldImp instance(int m, int n)
    {
        if(instance == null)
        {
            instance = new FieldImp(m,n);
        }
        return instance;
    }

    public void placeUnit(int x, int y, Unit unit)
    {
        slot[x][y] = unit;
    }

    public void removeUnit(int x, int y)
    {
        slot[x][y] = null;
    }

    public int isEmpty(int x, int y)
    {
        if(slot[x][y] == null)
            return 1;
        return 0;
    }
}
