package classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConfigImp {
    protected static final String inFile = "src/classes/configfile/config1.in";
    protected static ConfigImp instance;
    protected static int m;
    protected static int n;
    protected static double virusSpawn;
    protected static int antibody_credit;
    protected static int antibody_placementCost;
    protected static int virus_health;
    protected static int antibody_health;
    protected static int virus_damage;
    protected static int virus_gain;
    protected static int antibody_damage;
    protected static int antibody_gain;
    protected static int antibody_moveCost;
    protected static int antibody_credit_gain;

    private ConfigImp()
    {

    }

    public static ConfigImp getInstance()
    {
        if(instance == null)
            instance = new ConfigImp();
        return instance;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException{
        try(FileReader fr =  new FileReader(inFile);
        Scanner s = new Scanner(fr)){
            m = s.nextInt();
            n = s.nextInt();
            virusSpawn = s.nextDouble();
            antibody_credit = s.nextInt();
            antibody_placementCost = s.nextInt();
            virus_health = s.nextInt();
            antibody_health = s.nextInt();
            virus_damage = s.nextInt();
            virus_gain = s.nextInt();
            antibody_damage = s.nextInt();
            antibody_gain = s.nextInt();
            antibody_moveCost = s.nextInt();
            antibody_credit_gain = s.nextInt();
            // System.out.println("m = " + m);
            // System.out.println("n = " + n);
            // System.out.println("virus Spawn = " + virusSpawn);
            // System.out.println("antibody credit = " + antibody_credit);
            // System.out.println("antibody placement = " + antibody_placementCost);
            // System.out.println("virus health = " + virus_health);
            // System.out.println("antibody health = " + antibody_health);
            // System.out.println("virus damage = " + virus_damage);
            // System.out.println("virus gain = " + virus_gain);
            // System.out.println("antibody damage = " + antibody_damage);
            // System.out.println("antibody gain = " + antibody_gain);
            // System.out.println("antibody moveCost = " + antibody_moveCost);
            // System.out.println("antibody credit gain  = " + antibody_credit_gain);

        }
    }       
}
