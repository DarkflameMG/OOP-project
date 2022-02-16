package classes;
import interfaces.Unit;

public class UnitImp implements Unit {
    protected int hp = 0;
    protected int damage = 0;
    protected int defence = 0;
    protected int coordinateX;
    protected int coordinateY;
    protected String species;
    protected ConfigImp config = ConfigImp.getInstance();

    protected UnitImp(String species,int x,int y)
    {
        this.species = species;
        this.coordinateX = x;
        this.coordinateY = y;
    }

    public void move(int x,int y)
    {
        if(coordinateX + x >= 0 && coordinateY + y >= 0 && coordinateX + x <= config.m && coordinateY + y <= config.n)
        {
            coordinateX += x;
            coordinateY += y;
        }
    }

    public int isVirus()
    {
        if(species.equals("virus"))
            return 1;
        return 0;
    }

    public int isAntiBody()
    {
        if(species.equals("antibody"))
            return 1;
        return 0;
    }

    public void attack(Unit target)
    {
        target.decreaseHp(damage);
    }

    public void decreaseHp(int damage)
    {
        if (this.hp - damage >= 0)
            this.hp -= damage;
        else
            this.hp = 0;
    }

    public int getDamage()
    {
        return damage;
    }

    public int getHp()
    {
        return hp;
    }

    public int getDefence()
    {
        return defence;
    }
}