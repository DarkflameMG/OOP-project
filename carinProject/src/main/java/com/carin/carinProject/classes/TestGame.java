package com.carin.carinProject.classes;

import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import com.carin.carinProject.classes.parse.geneImp;
import com.carin.carinProject.interfaces.Unit;

import java.io.IOException;

public class TestGame {
    public static void main(String[] args) throws IOException, SyntaxError, TokenizerError {
        ConfigImp.main(args);
        geneImp.main(args);
        FieldImp field = FieldImp.getInstance(ConfigImp.getM(),ConfigImp.getN());
        Unit host = new AntiBodyImp("ox",2,3);
        Unit host2 = new AntiBodyImp("CO",1,1);
        field.placeUnit(2,3,host);
        field.placeUnit(1,1,host2);
        UnitCollection allU = UnitCollection.getInstance();
        allU.addUnit(host);
        allU.addUnit(host2);
        for(int k =0;k<10;k++)
        {
            for(int i=0;i<ConfigImp.getM();i++)
            {
                for (int j=0;j<ConfigImp.getN();j++)
                {
                    System.out.print("[");
                    if(field.isEmpty(i,j) > 0)
                    {
                        System.out.print("-");
                    }
                    else
                    {
                        System.out.print("*");
                    }
                    System.out.print("]");
                }
                System.out.println();
            }
            allU.UnitRun();
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
