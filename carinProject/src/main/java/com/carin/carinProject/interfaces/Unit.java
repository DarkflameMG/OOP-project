package com.carin.carinProject.interfaces;

public interface Unit {
    /**
     * move unit to another location
     * @param direction a number between 1 - 8
     */
    void move(int direction);

    /**
     * this unit attack target unit in input direction
     * @param direction a number between 1 - 8
     */
    void attack(int direction);

    /**
     * decrease this unit hp
     * @param damage a number that belong to enemy's damage
     */
    void decreaseHp(int damage);

    /**
     * check this unit if it is virus
     * @return 1 if this unit is virus else 0
     */
    int isVirus();

    /**
     * check this unit if it is Antibody
     * @return 1 if this unit is virus else 0
     */
    int isAntiBody();

    /**
     * return this Unit damage value
     * @return a number that greater than equal 0
     */
    int getDamage();

    /**
     * return this Unit current hp value
     * @return a number that greater than equal 0
     */
    int getHp();

    /**
     * transform form antibody to virus
     * @param species a name of virus that antibody transform
     */
    void transform(String species);

    /**
     * return direction and distant of the closest Unit
     * @return a number that number%10 is direction and number/10 is distant
     */
    int Sensor();

    /**
     * return distant and type of the closest Unit
     * @return a number that number%10 is type of Unit if 1 is virus else antibody
     *          number/10 is distant
     */
    int SensorNearby(int direction);
}