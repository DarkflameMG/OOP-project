package com.carin.carinProject.classes;

public class Credit {
    private int credit = ConfigImp.getAntibody_credit();
    private int gainCredit = ConfigImp.getAntibody_credit_gain();
    private static Credit instance;

    public static Credit getInstance()
    {
        if(instance == null)
            instance = new Credit();
        return instance;
    }

    public void CreditGain()
    {
        credit += gainCredit;
    }
}
