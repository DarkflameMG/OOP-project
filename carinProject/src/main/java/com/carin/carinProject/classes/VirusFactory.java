package com.carin.carinProject.classes;

public class VirusFactory {
    private static VirusFactory instance;

    private VirusFactory(){}

    public static VirusFactory getInstance()
    {
        if(instance == null)
            instance = new VirusFactory();
        return instance;
    }

    public VirusImp newVirus(String species)
    {
        return new VirusImp(species);
    }
}
