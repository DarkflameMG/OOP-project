package com.carin.carinProject.classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ConfigImp {
    private static final String inFile = "src/main/java/com/carin/carinProject/classes/configfile/config1.in";
//    protected static ConfigImp instance;
    private static int m;
    private static int n;
    private static double virusSpawn;
    private static int antibody_credit;
    private static int antibody_placementCost;
    private static int virus_health;
    private static int antibody_health;
    private static int virus_damage;
    private static int virus_gain;
    private static int antibody_damage;
    private static int antibody_gain;
    private static int antibody_moveCost;
    private static int antibody_credit_gain;

//    public static ConfigImp getInstance()
//    {
//        if(instance == null)
//            instance = new ConfigImp();
//        return instance;
//    }

    public static int getM()
    {
        return m;
    }

    public static int getN()
    {
        return n;
    }

    public static int getVirus_health()
    {
        return virus_health;
    }

    public static int getVirus_damage()
    {
        return virus_damage;
    }

    public static int getAntibody_health()
    {
        return antibody_health;
    }

    public static int getAntibody_damage()
    {
        return antibody_damage;
    }

    public static int getAntibody_gain()
    {
        return antibody_gain;
    }

    public static int getVirus_gain()
    {
        return virus_gain;
    }

    public static int getAntibody_credit()
    {
        return antibody_credit;
    }

    public static int getAntibody_placementCost()
    {
        return antibody_placementCost;
    }

    public static int getAntibody_moveCost()
    {
        return antibody_moveCost;
    }

    public static int getAntibody_credit_gain()
    {
        return antibody_credit_gain;
    }

    public static double getVirusSpawn()
    {
        return virusSpawn;
    }

    public int getX() {
        return m;
    }

    public int getY() {
        return n;
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
