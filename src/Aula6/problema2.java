package Aula6;

import myUtilAula3.*;
import myUtilAula6.ListsProcess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class problema2 {
    public static void main(String[] args) {
        List<Figura> lista = new ArrayList<Figura>();
        lista.add(new Circulo(2)); lista.add(new Circulo(1, 3, 1));
        lista.add(new Quadrado(5)); lista.add(new Quadrado(3, 4, 2));
        lista.add(new Retangulo(2, 3)); lista.add(new Retangulo(3, 4, 5, 3));
        lista.add(new Retangulo(1, 1, 5, 6));
        System.out.println("Figuras Filter 1:");
        List<Figura> ret = ListsProcess.filter(lista, f -> f.area() > 20);
        printList(ret);
        System.out.println("\nFiguras Filter 2:");
        ret = ListsProcess.filter(lista, f -> f.perimetro() < 15);
        printList(ret);
        System.out.println("\nFiguras Filter 3:");
        ret = ListsProcess.filter(lista, f -> f.perimetro() < 15 && f.area() > 10);
        printList(ret);
        List<Student> lista2 = new ArrayList<Student>();
        lista2.add(new Student("Andreia", "9855678", new Date(18, 7, 1974)));
        lista2.add(new Student("Monica", "75266454", new Date(11, 8, 1978)));
        lista2.add(new Student("Jose", "85265426", new Date(15, 2, 1976)));
        lista2.add(new Fellow("Maria", "8976543", new Date(12, 5, 1976)));
        lista2.add(new Fellow("Xico", "872356522", new Date(21, 4, 1975)));
        System.out.println("\nStudent Filter 1:");
        List<Student> ret2 = ListsProcess.filter(lista2, e -> e.getnMec() < 103);
        printList(ret2);

        System.out.println("\nStudent Filter 2:");
        ret2 = ListsProcess.filter(lista2,
                e -> e.getClass().getSimpleName().equals("Fellow"));
        printList(ret2);
    }
    private static <T> void printList(List<T> myList) {
        for (T e : myList)
            System.out.println(e);
    }
}
