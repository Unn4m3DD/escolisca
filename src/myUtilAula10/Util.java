package myUtilAula10;

import myUtilAula3.Figura;
import myUtilAula9.BFIterator;

import java.util.Iterator;

public class Util {
    public static double sumArea(BFIterator<? extends Figura> figuras) {
        double res = 0;
        for (var f = figuras.next(); figuras.hasNext(); f = figuras.next()) {
            res += ((Figura)f).area();
        }
        return res;
    }
    public static double sumArea(Iterator<? extends Figura> figuras) {
        double res = 0;
        for (var f = figuras.next(); figuras.hasNext(); f = figuras.next()) {
            res += ((Figura)f).area();
        }
        return res;
    }

    public static <T> void printSet (BFIterator<T> lista){
        for (var elem = lista.next(); lista.hasNext(); elem = lista.next()) {
            System.out.println(elem);
        }
    }
    public static <T> void printSet (Iterator<T> lista){
        for (var elem = lista.next(); lista.hasNext(); elem = lista.next()) {
            System.out.println(elem);
        }
    }
}
