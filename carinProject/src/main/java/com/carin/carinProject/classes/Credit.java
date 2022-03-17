package com.carin.carinProject.classes;

public class Credit {
    private int credit = ConfigImp.getAntibody_start_credit();
    private int gainCredit = ConfigImp.getAntibody_credit_gain();
    private static Credit instance;

    public static Credit getInstance()
    {
        if(instance == null)
            instance = new Credit();
        return instance;
    }

    public void restart()
    {
        credit = ConfigImp.getAntibody_start_credit();
    }

    public void CreditGain()
    {
        credit += gainCredit;
    }

    public void Buy(int buy_credit)
    {
        credit -= buy_credit;
    }

    public int current_credit()
    {
        return credit;
    }
}
