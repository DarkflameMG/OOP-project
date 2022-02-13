package interfaces;

public interface Unit {
    /**
     * move unit to another location
     */
    void move();

    /**
     * unit attack another difference species unit
     */
    void attack();

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
     * return unit's status
     * @return array of status
     */
    int[] status();
}