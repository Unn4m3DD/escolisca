package aula1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, String> dic = readDictionary();
        StringBuilder sb = new StringBuilder();
        Arrays.stream(args[0].split("[ -]")).forEach((item) -> sb.append(dic.getOrDefault(item, item)).append(" "));
        System.out.println(sb);
    }

    public static HashMap<String, String> readDictionary() throws FileNotFoundException {
        HashMap<String, String> dic = new HashMap<>();
        Scanner fs = new Scanner(new File("./resources/numbers.txt"));
        while (fs.hasNextLine()) {
            String[] nextItem = fs.nextLine().split((" - "));
            dic.put(nextItem[1], nextItem[0]);
        }
        return dic;
    }
}
