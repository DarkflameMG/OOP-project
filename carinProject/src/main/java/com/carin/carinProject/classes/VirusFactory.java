package com.carin.carinProject.classes;

import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;

public class VirusFactory {
    private static VirusFactory instance;

    private VirusFactory(){}

    public static VirusFactory getInstance()
    {
        if(instance == null)
            instance = new VirusFactory();
        return instance;
    }

    public VirusImp newVirus(String species,int x,int y)throws SyntaxError, TokenizerError
    {
        return new VirusImp(species,x,y);
    }
}
