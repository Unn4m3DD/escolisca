package aula1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ex1 {
    public static Scanner k = new Scanner(System.in);

    public static void main(String[] args) {
        String input = "";
        do {
            input = k.nextLine();
            String[] ops = input.split(" ");
            double result = ops[1].equals("+") ? Double.parseDouble(ops[0]) + Double.parseDouble(ops[2]) :
                    ops[1].equals("-") ? Double.parseDouble(ops[0]) - Double.parseDouble(ops[2]) :
                            ops[1].equals("*") ? Double.parseDouble(ops[0]) * Double.parseDouble(ops[2]) :
                                    ops[1].equals("/") ? Double.parseDouble(ops[0]) / Double.parseDouble(ops[2]) : 0;
            System.out.println(result);
        } while (!input.equals(""));
    }
}
