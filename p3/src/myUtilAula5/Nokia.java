package myUtilAula5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Nokia implements Parser{
    public ListaPessoas parseScanner(Scanner k) {
        ListaPessoas result = new ListaPessoas();
        while(k.hasNextLine()){
            String nome = k.nextLine();
            String tlm = k.nextLine();
            String data = k.nextLine();
            result.add(new Pessoa(nome, tlm, data));
        }
        return result;
    }

    public void writeFw(ListaPessoas lp, FileWriter fw) {
        try {

        fw.write("Nokia\n");
        for(Pessoa p: lp){
            fw.write(String.format("%s\n%s\n%s\n", p.getNome(), p.getNumero(), p.getDataNascimento()));
        }
        fw.write("\n");
        fw.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
