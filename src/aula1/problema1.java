package aula1;

import java.util.Scanner;

public class problema1 {
    public static Scanner k = new Scanner(System.in);
    public static void main(String[] args) {
        String input = k.nextLine();
        System.out.println("Total de caracteres numericos" + numCount(input));
        System.out.println("Só Maiusculas? " + (capital(input) ? "Sim" : "Não"));
        System.out.println("Só minusculas? " + (lowercase(input) ? "Sim" : "Não"));
        System.out.println("Caracteres Trocados 2 a 2: " + swapChar(input));
        System.out.print("Total de Palavras: \n" + arrayToString(input.split(" ")));

    }


    private static String swapChar(String input){
        String result = "";
        char[] chrarray = input.toCharArray();
        for(int i = 0; i < input.length(); i += 2){
            if(chrarray.length > i + 1)
                result += String.valueOf(chrarray[i + 1]) + String.valueOf(chrarray[i]);
            else
                result += String.valueOf(chrarray[i]);
        }
        return result;
    }
    private static String arrayToString(String[] input){
        String result = "";
        for(String word : input){
            result += word + "\n";
        }
        return result;
    }

    private static boolean capital(String input) {
        return input.equals(input.toUpperCase());
    }

    private static boolean lowercase(String input) {
        return input.equals(input.toLowerCase());
    }

    private static String numCount(String input) {
        int result = 0;
        for(char i : input.toCharArray()){
            try {
                double d = Integer.parseInt(String.valueOf(i));
            } catch (NumberFormatException | NullPointerException nfe) {
                continue;
                //o numero n é digito
            }
            result++;
        }
        return String.valueOf(result);
    }
}
