package myUtilAula5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVv implements Parser {
    public ListaPessoas parseScanner(Scanner k) {
        ListaPessoas result = new ListaPessoas();
        while (k.hasNextLine()) {
            String[] line = k.nextLine().split("    ");
            String nome = line[0];
            String tlm = line[1];
            String data = line[2];
            result.add(new Pessoa(nome, tlm, data));
        }
        return result;
    }

    public void writeFw(ListaPessoas lp, FileWriter fw) {
        try {
            fw.write("vCard\n");
            for (Pessoa p : lp) {
                fw.write(String.format("%s  %s  %s\n", p.getNome(), p.getNumero(), p.getDataNascimento()));
            }
            fw.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
