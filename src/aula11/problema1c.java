package aula11;

import myUtilAula10.Mutable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class problema1c {
    public static void main(String[] args) throws IOException {
        File f = new File("Infopublico.txt");
        TreeMap<String, Integer> map = new TreeMap<>();
        Files.readAllLines(Path.of(f.getAbsolutePath())).stream().map((e) -> e.split("[ ]+")).flatMap(Arrays::stream).forEach((s) -> {
            s = "\n" + s;
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        });
        System.out.println(map);
    }
}
