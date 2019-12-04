package aula11;

import myUtilAula10.Mutable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;

public class problema1b {
    public static void main(String[] args) throws IOException {
        File f = new File("Infopublico.txt");
        HashSet<String> set = new HashSet<String>();
        Mutable<Integer> count = new Mutable<>(0);
        Files.readAllLines(Path.of(f.getAbsolutePath())).stream().forEach((e) -> {
            for (var s : e.split(" ")) {
                set.add(s);
                count.set(count.get() + 1);
            }
        });
        System.out.println(set.size());
        System.out.println(count.get());
    }
}
