package myUtilAula5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ParserNokia{
    public static ListaPessoas parseScanner(Scanner k) {
        ListaPessoas result = new ListaPessoas();
        while(k.hasNextLine()){
            String nome = k.nextLine();
            String tlm = k.nextLine();
            String data = k.nextLine();
            result.add(new Pessoa(nome, tlm, data));
        }
        return result;
    }

    public static void writeFw(ListaPessoas lp, FileWriter fw) throws IOException {
        fw.write("Nokia\n");
        for(Pessoa p: lp){
            fw.write(String.format("%s\n%s\n%s\n", p.getNome(), p.getNumero(), p.getDataNascimento()));
        }
        fw.write("\n");
        fw.close();
    }
}
