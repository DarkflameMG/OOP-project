package com.carin.carinProject.classes;

import java.util.List;

public class GameData {
    private int virus;
    private int antibody;
    private int credit;
    private List<Integer> cost;
    private List<Integer> posX, posY, hp, hpMax;
    private List<Integer> type;

    public GameData(int virus, int antibody,  int credit,List<Integer> cost,  List<Integer> posX, List<Integer> posY, List<Integer> hp, List<Integer> hpMax, List<Integer> type) {
        this.virus = virus;
        this.antibody = antibody;
        this.credit = credit;
        this.cost = cost;
        this.posX = posX;
        this.posY = posY;
        this.hp = hp;
        this.hpMax = hpMax;
        this.type = type;
    }

    public GameData(int m, int n, Object o, Object cost, Object posX, Object posY, Object hp, Object hpMax) {
    }

    public int getVirus() {
        return virus;
    }

    public void setVirus(int virus) {
        this.virus = virus;
    }

    public int getAntibody() {
        return antibody;
    }

    public void setAntibody(int antibody) {
        this.antibody = antibody;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public List<Integer> getCost() {
        return cost;
    }

    public void setCost(List<Integer> cost) {
        this.cost = cost;
    }

    public List<Integer> getPosX() {
        return posX;
    }

    public void setPosX(List<Integer> posX) {
        this.posX = posX;
    }

    public List<Integer> getPosY() {
        return posY;
    }

    public void setPosY(List<Integer> posY) {
        this.posY = posY;
    }

    public List<Integer> getHp() {
        return hp;
    }

    public void setHp(List<Integer> hp) {
        this.hp = hp;
    }

    public List<Integer> getHpMax() {
        return hpMax;
    }

    public void setHpMax(List<Integer> hpMax) {
        this.hpMax = hpMax;
    }

    public List<Integer> getType() {
        return type;
    }

    public void setType(List<Integer> type) {
        this.type = type;
    }
}
