package com.carin.carinProject.classes.parse;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class geneImp {
    private static final String D_A = "src/main/java/com/carin/carinProject/classes/configfile/antibodyGene.in";
    private static final String D_V = "src/main/java/com/carin/carinProject/classes/configfile/virusGene.in";
    private static geneImp instance;
    private String antibodyGene;
    private String virusGene;

    private geneImp(){}

    public static geneImp getInstance()
    {
        if (instance == null)
            instance = new geneImp();
        return instance;
    }

    private void setA_Gene(String s)
    {
        antibodyGene = s;
    }

    private void setV_Gene(String s)
    {
        virusGene = s;
    }

    public String getAntibodyGene()
    {
        return antibodyGene;
    }

    public String getVirusGene()
    {
        return virusGene;
    }

    public static void Run() throws IOException
    {
        StringBuilder s = new StringBuilder();
        geneImp instance = geneImp.getInstance();

        try (FileReader fr =  new FileReader(D_A);
             Scanner scan = new Scanner(fr)){
            while(scan.hasNext())
            {
                s.append(scan.nextLine());
                s.append(" ");
            }
        }
        instance.setA_Gene(s.toString());

        s = new StringBuilder();
        try (FileReader fr =  new FileReader(D_V);
             Scanner scan = new Scanner(fr)){
            while(scan.hasNext())
            {
                s.append(scan.nextLine());
                s.append(" ");
            }
        }
        instance.setV_Gene(s.toString());
    }

//    public static void main(String[] args) throws IOException {
//        StringBuilder s = new StringBuilder();
//        geneImp instance = geneImp.getInstance();
//
//        try (FileReader fr =  new FileReader(D_A);
//             Scanner scan = new Scanner(fr)){
//            while(scan.hasNext())
//            {
//                s.append(scan.nextLine());
//                s.append(" ");
//            }
//        }
//        instance.setA_Gene(s.toString());
//
//        s = new StringBuilder();
//        try (FileReader fr =  new FileReader(D_V);
//             Scanner scan = new Scanner(fr)){
//            while(scan.hasNext())
//            {
//                s.append(scan.nextLine());
//                s.append(" ");
//            }
//        }
//        instance.setV_Gene(s.toString());
//    }
}
