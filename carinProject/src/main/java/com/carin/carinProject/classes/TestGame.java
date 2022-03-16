package com.carin.carinProject.classes;

import com.carin.carinProject.classes.Units.UnitCollection;
import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import com.carin.carinProject.classes.parse.geneImp;
import com.carin.carinProject.interfaces.Unit;

import java.io.IOException;

public class TestGame {
    public static void main(String[] args) throws IOException, SyntaxError, TokenizerError {
        ConfigImp.ReadFile();
        geneImp.Run();
        FieldImp field = FieldImp.getInstance(ConfigImp.getM(),ConfigImp.getN());
        Credit credit = Credit.getInstance();
        MainGame game = MainGame.getInstance();
        Shop shop = Shop.getInstance();
        UnitCollection allU = UnitCollection.getInstance();

        shop.buy("Machina",0,0);
        shop.buy("PongPong",1,4);
        shop.buy("Momotaros",2,5);

        int v_num = field.getNum_virus();
        int a_num = field.getNum_antibody();

        while((v_num !=0 && a_num !=0) || game.getGame_start() == 0 && v_num != ConfigImp.getM()*ConfigImp.getN())
//        for(int k=0;k<10;k++)
        {
            if(game.getGame_speed() == 0)
            {
                while (game.getGame_speed() != 0)
                {

                }
            }
            game.VirusSpawn();
            v_num = field.getNum_virus();
            a_num = field.getNum_antibody();
            System.out.println("Virus : "+field.getNum_virus());
            System.out.println("Antibody : "+field.getNum_antibody());
            System.out.println("Credit : "+credit.current_credit());
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
                            else{
                                System.out.print("V");
                            }
                        }
                    }
                    System.out.print("]");
                }
                System.out.println();
            }
            allU.UnitRun();
            System.out.println(UnitData.getInstance().getPosX());
            System.out.println(UnitData.getInstance().getPosY());
            System.out.println(UnitData.getInstance().getType());
            try {
                Thread.sleep(game.current_speedTime());
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
