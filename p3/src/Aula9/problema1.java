package Aula9;

import myUtilAula9.ScannerAbeirense;

import java.io.File;
import java.io.IOException;

public class problema1 {
    public static void main(String[] args) throws IOException {
        var sa = new ScannerAbeirense(new File("voos.txt"));
        for(var s: sa){
            System.out.println(s);
        }
    }
}
