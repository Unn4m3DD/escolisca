package aula5;

import myUtilAula5.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Scanner;

public class problema3 {
    static Parser parser;

    public static void main(String[] args) throws ClassNotFoundException, IOException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String[] files = {"f1.txt", "f2.txt", "f3.txt"};
        for (String f : files) {
            Scanner k = new Scanner(new File(f));
            ListaPessoas lp = null;
            var s = k.nextLine();
                parser = getParser("myUtilAula5." + s);
            if (parser != null) {
                lp = (parser).parseScanner(k);
                if (lp != null) {
                    (parser).writeFw(lp, new FileWriter(new File(s + f)));
                    System.out.println(lp);
                }
            }
        }
    }

    private static Parser getParser(String s) throws ClassNotFoundException, MalformedURLException, IllegalAccessException, InstantiationException, InvocationTargetException {
        File plugin = new File("plugins");
        URLClassLoader classLoader = new URLClassLoader(new URL[]{plugin.toURI().toURL()});
        Class<?> clazz = classLoader.loadClass(s);
        var p = (Parser) clazz.getConstructors()[0].newInstance();
        return p;
    }
}
