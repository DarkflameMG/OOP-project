package com.carin.carinProject.classes;

public class AntibodyFactory {
    private static AntibodyFactory instance;

    private AntibodyFactory(){}

    public static AntibodyFactory getInstance()
    {
        if (instance == null)
            instance = new AntibodyFactory();
        return instance;
    }
    public AntiBodyImp newAntibody(String species)
    {
        return new AntiBodyImp(species);
    }
}
