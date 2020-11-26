package aula1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex5 {
    public static Scanner k = new Scanner(System.in);

    public static void main(String[] args) {
        String input = "";
        HashMap<String, Double> map = new HashMap<>();
        do {
            input = k.nextLine();
            String[] ops = input.split("[ ]+");
            if (ops[1].equals("=")) {
                map.put(ops[0], Double.parseDouble(ops[2]));
                System.out.println(map);
            } else {
                System.out.println(map);

                double op1 = map.containsKey(ops[0]) ? map.get(ops[0]) : Double.parseDouble(ops[0]);
                double op2 = map.containsKey(ops[2]) ? map.get(ops[2]) : Double.parseDouble(ops[2]);
                double result = ops[1].equals("+") ? (op1) + (op2) :
                        ops[1].equals("-") ? (op1) - (op2) :
                                ops[1].equals("*") ? (op1) * (op2) :
                                        ops[1].equals("/") ? (op1) / (op2) : 0;
                System.out.println(result);
            }
        } while (!input.equals(""));
    }
}
