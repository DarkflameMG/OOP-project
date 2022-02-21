package interfaces;

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
     */
    void transform();
}