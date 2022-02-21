package main.java.com.carin.carinProject.classes;
<<<<<<< HEAD:src/classes/AntiBodyImp.java

=======
import main.java.com.carin.carinProject.interfaces.AntiBodyUnit;
import main.java.com.carin.carinProject.interfaces.Unit;
>>>>>>> 7e8b85a6ddedf694d8b858598b7d4b51c95e7d4d:carinProject/src/main/java/com/carin/carinProject/classes/AntiBodyImp.java

public class AntiBodyImp extends UnitImp implements AntiBodyUnit {
    private final int hp_gain = ConfigImp.getAntibody_gain();

    public AntiBodyImp(String species)
    {
        super("antibody",species,0,0);
    }

    @Override
    public void transform()
    {

    }

    public void recovery()
    {
        hp += hp_gain;
    }

    @Override
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
        {
            target.decreaseHp(damage);
            if(target.getHp() == 0)
            {
                recovery();
            }
        }
    }
}
