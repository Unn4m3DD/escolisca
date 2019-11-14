package aula5;

import myUtilAula2.ClientList;
import myUtilAula5.ListaPessoas;
import myUtilAula5.ParserCSV;
import myUtilAula5.ParserNokia;
import myUtilAula5.ParserVcard;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class problema3 {
    public static void main(String[] args) throws IOException {
        String[] files = {"f1.txt", "f2.txt", "f3.txt"};
        for (String f : files) {
            Scanner k = new Scanner(new File(f));
            ListaPessoas lp = null;
            switch (k.nextLine()) {
                case "Nokia":
                    lp = ParserNokia.parseScanner(k);
                    break;

                case "CSV":
                    lp = ParserCSV.parseScanner(k);
                    break;

                case "vCard":
                    lp = ParserVcard.parseScanner(k);
                    break;
            }
            ParserVcard.writeFw(lp,new FileWriter(new File("vCard" + f)));
            ParserCSV.writeFw(lp,new FileWriter(new File( "CSV" + f)));
            ParserNokia.writeFw(lp,new FileWriter(new File("Nokia" + f)));
            System.out.println(lp);
        }
    }
}
