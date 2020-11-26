package aula1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class ex4 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> dic = readDictionary();
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] line = args[0].split(" and |[ -]");
        for (int i = line.length - 1; i >= 0; i--) {
            stack.push(line[i]);
        }
        int last = 0, total = 0, semiTotal = 0;
        while (!stack.isEmpty()) {
            int next = dic.get(stack.pop());
            if (next > last) {
                semiTotal = semiTotal == 0 ? next : semiTotal * next;
            } else {
                total += semiTotal + next;
                semiTotal = 0;
            }
            last = next;
        }

        System.out.println(total);
    }

    public static HashMap<String, Integer> readDictionary() throws FileNotFoundException {
        HashMap<String, Integer> dic = new HashMap<>();
        Scanner fs = new Scanner(new File("./resources/numbers.txt"));
        while (fs.hasNextLine()) {
            String[] nextItem = fs.nextLine().split((" - "));
            dic.put(nextItem[1], Integer.parseInt(nextItem[0]));
        }
        return dic;
    }
}
