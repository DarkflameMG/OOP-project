package classes;

public class ConfigImp {
    protected static ConfigImp instance;
    protected int m;
    protected int n;

    private ConfigImp()
    {

    }

    public static ConfigImp getInstance()
    {
        if(instance == null)
            instance = new ConfigImp();
        return instance;
    }
}
