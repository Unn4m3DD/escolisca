package myUtilAula9;

import java.util.ArrayList;

public abstract class Gelado {
    Gelado(){
    }

    public String baseS(int n){
        return n + " bola" + (n == 1? " ": "s ");
    }
    public void base(int n){
        System.out.println(baseS(n));
    }
}
