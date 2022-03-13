package com.carin.carinProject.classes;

public class Status {
    private Credit credit = Credit.getInstance();
    private FieldImp field = FieldImp.getInstance(ConfigImp.getM(),ConfigImp.getN());
    private int m = ConfigImp.getM();
    private int n = ConfigImp.getN();

    //    private int money;

//    public Status(int money){
//        this.money = money;
//    }
//
//    public void setMoney(int money){
//        this.money = money;
//    }

    public int getCredit(){
       return credit.current_credit();
    }

    public int getNum_antibody()
    {
        return field.getNum_antibody();
    }

    public int getNum_virus()
    {
        return field.getNum_virus();
    }


}
