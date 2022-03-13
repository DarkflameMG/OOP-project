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
        AntibodyFactory.getInstance().newAntibody("A1",4,0);
        VirusFactory.getInstance().newVirus("V1",0,4);
        AntibodyFactory.getInstance().newAntibody("A2",2,3);
//        AntibodyFactory.getInstance().newAntibody("A3",3,3);
        VirusFactory.getInstance().newVirus("V2",3,2);
        VirusFactory.getInstance().newVirus("V3",1,0);
        UnitCollection allU = UnitCollection.getInstance();

        int v_num = field.getNum_virus();
        int a_num = field.getNum_antibody();

        while(v_num !=0 && a_num !=0)
        {
            v_num = field.getNum_virus();
            a_num = field.getNum_antibody();
            allU.UnitRun();
            System.out.println("Virus : "+field.getNum_virus());
            System.out.println("Antibody : "+field.getNum_antibody());
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
