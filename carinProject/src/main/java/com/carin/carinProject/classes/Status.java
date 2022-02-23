package com.carin.carinProject.classes;

public class Status {
    private int money;
    private int max_wave ;
    private int cur_wave ;

    public Status(int money,int max_wave, int cur_wave){
        this.money = money;
        this.max_wave = max_wave;
        this.cur_wave = cur_wave;
    }

    public void setMoney(int money){
        this.money = money;
    }
    public void setMaxWave(int max_wave){
        this.max_wave = max_wave;
    }
    public void setCurWave(int cur_wave){
        this.cur_wave = cur_wave;
    }

    public int getMoney(){
       return money;
    }
    public int getMaxWave(){
        return max_wave;
    }
    public int getCurWave(){
        return cur_wave;
    }

    @Override
    public String toString(){
        return "Status{"+
        "money" + money + '\'' +
        "max_wave" + max_wave + '\''+
        "cur_wave" + cur_wave +
        "}";
    }
}
