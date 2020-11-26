package Aula13;

import myUtilAula13.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class problema2 {
    static String pattern = "[ \n\t.,:'‘’;?!-*{}=+&/()\\]\\[”“\"]+";
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("texteGuiao13.txt");
        Scanner k = new Scanner(f);
        List<String> words = new LinkedList<>();
        while (k.hasNextLine()){
            for(String s : k.nextLine().split(pattern)) {
                words.add(s);
            }
        }
        TreeMap<Pair<String, String>, Integer> pairs = new TreeMap<>();
        for (int i = 0; i < words.size() - 1; i++) {
            Pair<String, String> pair = new Pair<>(words.get(i), words.get(i+1));
            pairs.putIfAbsent(pair, 0);
            pairs.put(pair, pairs.get(pair) + 1);
        }
        TreeMap<String, List<Pair<String, Integer>>> newPairs = new TreeMap<>();
        for (Pair<String, String> pair : pairs.keySet()) {
            newPairs.putIfAbsent(pair.getElem1(), new LinkedList<>());
            newPairs.get(pair.getElem1()).add(new Pair<>(pair.getElem2(), pairs.get(pair)));
        }

        for (String s : newPairs.keySet()) {
            String sep = "";
            String toPrint = s + "={";
            for (Pair<String, Integer> stringIntegerPair : newPairs.get(s)) {
                toPrint += sep + stringIntegerPair.getElem1() + "=" + stringIntegerPair.getElem2();
                sep = ", ";
            }
            System.out.println(toPrint + "}");
        }
    }
}
