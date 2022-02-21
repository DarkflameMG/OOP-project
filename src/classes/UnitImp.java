package classes;
import classes.parse.GeneticGrammar;
import interfaces.Unit;

public class UnitImp implements Unit {
    protected int hp = 0;
    protected int damage = 0;
    protected int coordinateX;
    protected int coordinateY;
    protected GeneticGrammar gene;
    protected String type;
    protected String species;

    protected UnitImp(String type,String species,int x,int y)
    {
        this.type = type;
        this.species = species;
        this.coordinateX = x;
        this.coordinateY = y;
    }

    private void initStat(String type)
    {
        if(type.equals("virus"))
        {
            hp = ConfigImp.getVirus_health();
            damage = ConfigImp.getVirus_damage();
        }
        else if(type.equals("antibody"))
        {
            hp = ConfigImp.getAntibody_health();
            damage = ConfigImp.getAntibody_damage();
        }
    }

    public void move(int direction)
    {
        FieldImp field = FieldImp.getInstance(10,10);
        int m = ConfigImp.getM();
        int n = ConfigImp.getN();

        int x = 0,y = 0;
        if(direction == 1 || direction == 2 || direction == 8)
            y = 1;
        if(direction == 4 || direction == 5 || direction == 6)
            y = -1;
        if(direction == 2 || direction == 3 || direction == 4)
            x = 1;
        if(direction == 6 || direction == 7 || direction == 8)
            x = -1;

        if(coordinateX + x >= 0 && coordinateY + y >= 0 && coordinateX + x <= m && coordinateY + y <= n)
        {
            field.removeUnit(coordinateX,coordinateY);
            coordinateX += x;
            coordinateY += y;
            field.placeUnit(coordinateX,coordinateY,this);
        }
    }

    public int isVirus()
    {
        if(type.equals("virus"))
            return 1;
        return 0;
    }

    public int isAntiBody()
    {
        if(type.equals("antibody"))
            return 1;
        return 0;
    }

    public void attack(int direction)
    {
        FieldImp field = FieldImp.getInstance(10,10);
        int x = coordinateX,y = coordinateY;
        if(direction == 1 || direction == 2 || direction == 8)
            y += 1;
        if(direction == 4 || direction == 5 || direction == 6)
            y -= 1;
        if(direction == 2 || direction == 3 || direction == 4)
            x += 1;
        if(direction == 6 || direction == 7 || direction == 8)
            x -= 1;
        Unit target = field.getTarget(x,y);
        if(target != null)
            target.decreaseHp(damage);
    }

    public void decreaseHp(int damage)
    {
        if (this.hp - damage >= 0)
            this.hp -= damage;
        else
        {
            this.hp = 0;
            if(isVirus() > 0)
            {
                FieldImp field = FieldImp.getInstance(10,10);
                field.removeUnit(coordinateX,coordinateY);
            }
        }
    }

    public int getDamage()
    {
        return damage;
    }

    public int getHp()
    {
        return hp;
    }

    public void transform()
    {

    }

}