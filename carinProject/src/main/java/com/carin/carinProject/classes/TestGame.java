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
        Unit host = AntibodyFactory.getInstance().newAntibody("ox",4,0);
        Unit host2 = VirusFactory.getInstance().newVirus("cx",0,4);
        UnitCollection allU = UnitCollection.getInstance();
        allU.addUnit(host);
        allU.addUnit(host2);

        System.out.println("m "+ConfigImp.getM()+" n "+ConfigImp.getN());
        for(int k =0;k<5;k++)
        {
            for(int i=0;i<ConfigImp.getN();i++)
            {
                for (int j=0;j<ConfigImp.getM();j++)
                {
                    System.out.print("[");
                    if(field.isEmpty(j,i) > 0)
                    {
                        System.out.print("-");
                    }
                    else
                    {
                        Unit U = field.getTarget(j,i);
                        if(U != null)
                        {
                            if(U.isAntiBody() > 0)
                                System.out.print("A");
                            else
                                System.out.print("V");
                        }
                    }
                    System.out.print("]");
                }
                System.out.println();
            }
            allU.UnitRun();
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
