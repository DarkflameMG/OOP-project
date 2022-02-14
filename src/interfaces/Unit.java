package interfaces;

public interface Unit {
    /**
     * move unit to another location
     */
    void move();

    /**
     * this unit attack target unit
     * @param target a Unit that this Unit attack for decrease hp
     */
    void attack(Unit target);

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
     * return this Unit defence value
     * @return a number that greater than equal 0
     */
    int getDefence();
}