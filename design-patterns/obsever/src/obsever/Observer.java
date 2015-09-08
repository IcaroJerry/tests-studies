package obsever;

import java.util.Observable;

public class Observer implements java.util.Observer{

    public Observer(String name)
    {
        this.name = name;
    }
    
    
    @Override
    public void update(Observable o, Object o1) {
        System.out.print(name+": actualized!\n\n");
    }
    
    
    private String name;
}
