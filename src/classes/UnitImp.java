package classes;
import interfaces.Unit;

public class UnitImp implements Unit {
    protected int hp = 0;
    protected int damage = 0;
    protected int defence = 0;
    protected String species;

    protected UnitImp(String species)
    {
        this.species = species;
    }

    public void move()
    {

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