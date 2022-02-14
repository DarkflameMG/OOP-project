package interfaces;

public interface Field {
    /**
     * place unit in slot(x,y)
     * @param x a number of x-axis
     * @param y a number of y-axis
     * @param unit a Unit that place in slot
     */
    void placeUnit(int x,int y,Unit unit);

    /**
     * clear slot (x,y) empty
     * @param x a number of x-axis
     * @param y a number of y-axis
     */
    void removeUnit(int x,int y);

    /**
     * check slot(x,y) if it's empty
     * @param x a number of x-axis
     * @param y a number of y-axis
     * @return 1 if slot(x,y) is empty else return 0
     */
    int isEmpty(int x,int y);
}
