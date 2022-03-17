package com.carin.carinProject.classes;

import com.carin.carinProject.classes.Units.UnitCollection;
import com.carin.carinProject.classes.parse.SyntaxError;
import com.carin.carinProject.classes.parse.TokenizerError;
import com.carin.carinProject.classes.parse.geneImp;
import com.carin.carinProject.interfaces.Unit;
import com.sun.tools.javac.Main;

import java.io.IOException;

public class TestGame {
    public static void main(String[] args) throws IOException, SyntaxError, TokenizerError {
        ConfigImp.ReadFile();
        geneImp.Run();
        FieldImp field = FieldImp.getInstance(0,0);
        field.restart();
        Credit credit = Credit.getInstance();
        credit.restart();
        MainGame game = MainGame.getInstance();
        game.notend();
        Shop shop = Shop.getInstance();
        UnitCollection allU = UnitCollection.getInstance();
        allU.newCollection();

//        shop.buy(5,0,0);
//        shop.buy(4,1,4);
//        shop.buy(6,2,5);

        int v_num = field.getNum_virus();
        int a_num = field.getNum_antibody();

        while(MainGame.getCurrent_state() != 1)
        {
            System.out.println(MainGame.getCurrent_state());
        }
        while((v_num !=0 && a_num !=0) ||  v_num != ConfigImp.getM()*ConfigImp.getN())
//        for(int k=0;k<10;k++)
        {
            System.out.println("speed "+MainGame.getCurrent_speed());
            while (MainGame.getCurrent_speed() == 0)
            {
                System.out.println("pause");
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
//            System.out.println(UnitData.getInstance().getPosX());
//            System.out.println(UnitData.getInstance().getPosY());
//            System.out.println(UnitData.getInstance().getType());
            if((v_num ==0 || a_num ==0) && game.getVirus_count() >= 3 && shop.getAntibody_count() >=3)
                break;
            if(MainGame.getGameEnd() == 1)
                break;
            try {
                Thread.sleep(game.current_speedTime());
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println();
        }
        System.out.println("end");
    }

    public static void Run() throws SyntaxError, TokenizerError, IOException {
        ConfigImp.ReadFile();
        geneImp.Run();
        FieldImp field = FieldImp.getInstance(0,0);
        field.restart();
        Credit credit = Credit.getInstance();
        credit.restart();
        MainGame game = MainGame.getInstance();
        game.notend();
        Shop shop = Shop.getInstance();
        UnitCollection allU = UnitCollection.getInstance();
        allU.newCollection();

//        shop.buy(5,0,0);
//        shop.buy(4,1,4);
//        shop.buy(6,2,5);

        int v_num = field.getNum_virus();
        int a_num = field.getNum_antibody();

        while(MainGame.getCurrent_state() != 1)
        {
            System.out.println(MainGame.getCurrent_state());
        }
        while((v_num !=0 && a_num !=0) ||  v_num != ConfigImp.getM()*ConfigImp.getN())
//        for(int k=0;k<10;k++)
        {
            System.out.println("speed "+MainGame.getCurrent_speed());
            while (MainGame.getCurrent_speed() == 0)
            {
                System.out.println("pause");
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
//            System.out.println(UnitData.getInstance().getPosX());
//            System.out.println(UnitData.getInstance().getPosY());
//            System.out.println(UnitData.getInstance().getType());
            if((v_num ==0 || a_num ==0) && game.getVirus_count() >= 3 && shop.getAntibody_count() >=3)
                break;
            if(MainGame.getGameEnd() == 1)
                break;
            try {
                Thread.sleep(game.current_speedTime());
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println();
        }
        System.out.println("end");
    }
}
