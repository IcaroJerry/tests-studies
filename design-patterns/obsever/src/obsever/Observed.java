package obsever;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Observed extends java.util.Observable{

    public Observed() {
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValor(int valor) {
        this.value = valor;
        this.setChanged();
        this.notifyObservers();
    }
   
    
    private int value;
}
