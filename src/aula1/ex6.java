package aula1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ex6 {
    static HashMap<String, String> dic;

    public static void main(String[] args) throws FileNotFoundException {
        dic = readDictionary("./resources/" + args[0]);
        System.out.println(dic);
        System.out.println(decode(args[1]));
    }

    public static String decode(String string) {
        String[] tokens = string.split(" ");
        if (tokens.length == 1) {
            String result = dic.getOrDefault(tokens[0], tokens[0]);
            if (result.split(" ").length > 1) return decode(result);
            else return result;
        }
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for (String token : tokens) {
            sb.append(sep).append(decode(token));
            sep = " ";
        }
        return sb.toString();
    }

    //as dispositivos de batalha ou conflito armado e os nobres que se distinguiram em batalha ou conflito armado assinalados
    //as dispositivos de batalha ou conflito armado e os nobres que se distinguiram em batalha ou conflito armado assinalados
    public static HashMap<String, String> readDictionary(String path) throws FileNotFoundException {
        HashMap<String, String> dic = new HashMap<>();
        Scanner fs = new Scanner(new File(path));
        while (fs.hasNextLine()) {
            String[] nextItem = fs.nextLine().split("[ ]+");
            StringBuilder sb = new StringBuilder();
            String sep = "";
            for (int i = 1; i < nextItem.length; i++) {
                sb.append(sep).append(nextItem[i]);
                sep = " ";
            }
            dic.put(nextItem[0], sb.toString());
        }
        return dic;
    }
}
