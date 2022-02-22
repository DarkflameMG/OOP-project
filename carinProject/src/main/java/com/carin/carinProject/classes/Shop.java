package com.carin.carinProject.classes;

public class Shop {
    private int cost = ConfigImp.getAntibody_placementCost();
    private FieldImp field = FieldImp.getInstance(ConfigImp.getM(),ConfigImp.getN());
    private AntibodyFactory AFac = AntibodyFactory.getInstance();

    public void buy(String species,int x,int y)
    {
        AntiBodyImp Antibody = AFac.newAntibody(species);
        if(field.isEmpty(x,y) > 0)
            field.placeUnit(x,y,Antibody);
        else
            System.out.println("can't place");
    }
}
