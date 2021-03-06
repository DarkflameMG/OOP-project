package com.carin.carinProject.classes.Units;
import com.carin.carinProject.classes.ConfigImp;
import com.carin.carinProject.classes.FieldImp;
import com.carin.carinProject.classes.parse.GeneticGrammar;
import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import com.carin.carinProject.classes.parse.geneImp;
import com.carin.carinProject.interfaces.Unit;


public class UnitImp implements Unit {
    protected int hp = 0;
    protected int damage = 0;
    protected int coordinateX;
    protected int coordinateY;
    protected GeneticGrammar gene;
    protected String type;
    protected String species;
    protected FieldImp field = FieldImp.getInstance(ConfigImp.getM(),ConfigImp.getN());

    protected UnitImp(String type,String species,int x,int y) throws SyntaxError, TokenizerError
    {
        this.type = type;
        this.species = species;
        this.coordinateX = x;
        this.coordinateY = y;
        initStat(type);
        if(type.equals("antibody"))
            this.gene = new GeneticGrammar(geneImp.getInstance().getAntibodyGene(),this);
        else if(type.equals("virus"))
            this.gene = new GeneticGrammar(geneImp.getInstance().getVirusGene(),this);
    }

    private void initStat(String type)
    {
        if(type.equals("virus"))
        {
            hp = ConfigImp.getVirus_health();
            damage = ConfigImp.getVirus_damage();
            if(species.equals("Mimi"))
            {
                hp*=2;
            }
            // Damage Highest
            else if(species.equals("Karon"))
            {
                damage*=2;
            }
        }
        else if(type.equals("antibody"))
        {
            hp = ConfigImp.getAntibody_health();
            damage = ConfigImp.getAntibody_damage();
            // HP Highest
            if(species.equals("PongPong"))
            {
                hp*=2;
            }
            // Damage Highest
            else if(species.equals("Machina"))
            {
                damage*=2;
            }
        }
    }

    public int getCoordinateX()
    {
        return coordinateX;
    }

    public int getCoordinateY()
    {
        return coordinateY;
    }

    public int getSpecies()
    {
        if(species.equals("Mimi"))
            return 1;
        else if(species.equals("Karon"))
            return 2;
        else if(species.equals("Abnormal"))
            return 3;
        else if(species.equals("PongPong"))
            return 4;
        else if(species.equals("Machina"))
            return 5;
        else if(species.equals("Momotaros"))
            return 6;
        return 0;
    }

    public void move(int direction)
    {
        FieldImp field = FieldImp.getInstance(10,10);
        int m = ConfigImp.getM();
        int n = ConfigImp.getN();

        int x = 0,y = 0;
        if(direction == 1 || direction == 2 || direction == 8)
            y = -1;
        if(direction == 4 || direction == 5 || direction == 6)
            y = 1;
        if(direction == 2 || direction == 3 || direction == 4)
            x = 1;
        if(direction == 6 || direction == 7 || direction == 8)
            x = -1;

        if(coordinateX + x >= 0 && coordinateY + y >= 0 && coordinateX + x < m && coordinateY + y < n
                && field.isEmpty(coordinateX+x,coordinateY+y) > 0)
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
        if (this.hp - damage > 0)
            this.hp -= damage;
        else
        {
            this.hp = 0;
            field.removeUnit(coordinateX,coordinateY);
            UnitCollection allU = UnitCollection.getInstance();
            allU.removeUnit(this);
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

    public void transform(String species) throws TokenizerError, SyntaxError
    {

    }

    public int Sensor()
    {
        return 0;
    }

    public int SensorNearby(int direction)
    {
        int Max = Math.max(ConfigImp.getM(),ConfigImp.getN());
        for(int i=1;i<=Max;i++)
        {
            int x = coordinateX,y = coordinateY;
            if(direction == 1 || direction == 2 || direction == 8)
                y += i;
            if(direction == 4 || direction == 5 || direction == 6)
                y -= i;
            if(direction == 2 || direction == 3 || direction == 4)
                x += i;
            if(direction == 6 || direction == 7 || direction == 8)
                x -= i;
            Unit target = field.getTarget(x,y);
            if(target != null)
            {
                if(target.isVirus() > 0)
                    return (i*10)+1;
                return (i*10)+2;
            }
        }
        return 0;
    }

    public void run() throws TokenizerError,SyntaxError
    {
        gene.parseProgram().execute();
        if(type.equals("antibody"))
            this.gene = new GeneticGrammar(geneImp.getInstance().getAntibodyGene(),this);
        else if(type.equals("virus"))
            this.gene = new GeneticGrammar(geneImp.getInstance().getVirusGene(),this);
    }

}