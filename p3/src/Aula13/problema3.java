package Aula13;

import myUtilAula13.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class problema3 {
    //a) arraylist
    //b) hashmap
    //c)
    public static void main(String[] args) {
        ArrayList<Pair<String, String>> empregados = new ArrayList<>();
        empregados.add(new Pair<String, String>("Joao", "silva"));
        empregados.add(new Pair<String, String>("Manuel", "Paiva"));
        empregados.add(new Pair<String, String>("Antonio", "Jose"));

        HashMap<String, String> premios = new HashMap<>();
        premios.put(empregados.get((int) (empregados.size() * Math.random())).getElem1(), "Brinquedo1");

        ArrayList<Pair<String, String>> produtos = new ArrayList<>();
        produtos.add(new Pair<String, String>(empregados.get((int) (empregados.size() * Math.random())).getElem1(), "produto"));

        HashMap<String, Integer> primeiroNomeCount = new HashMap<>();
        for (Pair<String, String> empregado : empregados) {
            primeiroNomeCount.putIfAbsent(empregado.getElem1(), 0);
            primeiroNomeCount.put(empregado.getElem1(), primeiroNomeCount.get(empregado.getElem1()) + 1);
        }
        System.out.println(primeiroNomeCount);
        LinkedList<Pair<String, String>> listaIteravelRotativa = new LinkedList<>(empregados);
        for (Pair<String, String> stringStringPair : listaIteravelRotativa) {
            System.out.println(stringStringPair);
        }
    }
}
