package aula1;

import myUtilAula1.Circulo;
import myUtilAula1.Point;
import myUtilAula1.Quadrado;
import myUtilAula1.Retangulo;

public class problema3 {
    public static void main(String[] args) {
        Circulo c1 = new Circulo(new Point(0,0), 5);
        Circulo c2 = new Circulo(new Point(1,2), 5);
        Circulo c3 = new Circulo(new Point(), 5);
        System.out.println(c1);
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c1.intercepts(c2));
        Retangulo r1 = new Retangulo(1,2,new Point(0,2));
        Retangulo r2 = new Retangulo(2,2,new Point(0,4));
        System.out.println(r1);
        System.out.println(r1.equals(r2));
        System.out.println(r1.area());
        System.out.println(r2.perimetro());
        Quadrado q1 = new Quadrado(2, new Point(0,4));
        Quadrado q2 = new Quadrado(1, new Point(0,2));
        System.out.println(q1);
        System.out.println(q2.equals(q1));
        System.out.println(q1.area());
        System.out.println(q1.perimetro());
        System.out.println(q1.equals(r2));
    }
}
