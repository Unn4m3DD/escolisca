package src;

import javax.sound.sampled.Line;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import static src.Cliente.TipoCliente;
//Notas:
//Não altere o código apresentado

// ReadMe:
// Foi adicionada à lista de exceptions lançadas pelas funções  main e alinea1 a exception Exception do java, já que o mecanismo de controlo de
// Debito ou Credito utiliza exceptions do tipo exceptiom
// O mesmo funcionamento poderia ser atingido nao alterando o codigo utilizando exceptions personalizadas e unchecked.


//Deve completar o código da alinea 2
//Comente o código com erros para garantir que vai executando parcialmente

public class P3_19 {

    public static void main(String[] args) throws Exception {
        Banco obanco = new Banco("PeDeMeia");
        PrintStream fl = new PrintStream(new File("resources/p3_1920C.txt"));
        alinea1(obanco, System.out); // executa e escreve na consola
        alinea2(obanco, fl); // executa e escreve no ficheiro
        fl.close();
    }

    public static void alinea1(Banco b, PrintStream out) throws Exception {
        out.println("\nAlínea 1) ----------------------------------\n");

        Cliente c1 = new Individual("Manuel Lima", "281656798", TipoCliente.Balcao);
        Cliente c2 = new Individual("Carla Marques", "301317832", TipoCliente.Balcao, "234500232");
        Cliente c3 = new Individual("José Bento", "224456720", TipoCliente.Online, "234630535");
        Cliente c4 = new Empresa("Lima & Irmao", "509434438", TipoCliente.Online, c1);
        Cliente c5 = new Empresa("Reboques Tudo o Bento Leva", "509782153", TipoCliente.Balcao, c3);

        //src.Conta bad = new src.eConta(c1); 							// Gera uma Excepção
        Conta contas[] = {new Conta(c1), new Conta(c2), new eConta(c3), new eConta(c4), new Conta(c5)};
        System.out.print(b.add(contas[0]) + ", ");        // true
        System.out.print(b.add(contas[1]) + ", ");        // true
        System.out.print(b.add(contas[2]) + ", ");        // true
        System.out.print(b.add(contas[3]) + ", ");        // true
        System.out.print(b.add(contas[4]) + ", ");        // true
        System.out.print(b.add(contas[1]) + "\n");        // false

        contas[0].add(new Credito(1000, "20191231"));
        contas[1].add(new Credito(2000, "20191231"));
        contas[2].add(new Credito(1400, "20191231"));
        contas[3].add(new Credito(4000, "20191231"));

        System.out.println("\n----- Listagem de contas -----");
        for (Iterator<Conta> ri = b.iterator(); ri.hasNext(); )
            System.out.println(ri.next());

    }

    private static void alinea2(Banco b, PrintStream out) throws IOException {
        System.out.println("\n\n----- Alínea 2) -----\n");
        // Adicione a seguir o código necessário para ler e processar o ficheiro com os movimentos de conta (usar java streams)
        Files.readAllLines(Path.of("resources/movimentos.txt"))
                .forEach(e -> {
                    String[] splited = e.split(";");
                    try {
                        if (splited[0].equals("D"))
                            b.add(Integer.parseInt(splited[1]), new Debito(-1 * Integer.parseInt(splited[2]), splited[3]));
                        else if (splited[0].equals("C"))
                            b.add(Integer.parseInt(splited[1]), new Credito(Integer.parseInt(splited[2]), splited[3]));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
        System.out.println("----- Listagem De Contas Pós Movimentos -----");
        for (Iterator<Conta> ri = b.iterator(); ri.hasNext(); )
            System.out.println(ri.next());


        // Adicione a seguir o código necessário para escrever para ficheiro a lista de contas com saldo negativo (usar java streams)
        System.out.println("----- Contas com saldo negativo -----");
        StringBuilder negativeBankAcc = new StringBuilder();
        b.getContas().stream().filter(e -> e.getSaldo() < 0).forEach(e -> {
            negativeBankAcc.append(e.toString());
            negativeBankAcc.append("\n");
        });
        System.out.println(negativeBankAcc.toString());
        try (FileWriter fw = new FileWriter(new File("resources/contasComSaldoNegativo.txt"))) {
            fw.write(negativeBankAcc.toString());
        } // autoclosed


        // Adicione a seguir o código necessário para escrever para ficheiro o saldo total das contas eletrónicas (usar java streams)
        System.out.println("\n----- Saldo total das contas eletrónicas -----");
        double saldoTotalOnline = b.getContas().stream().filter(e -> {
            try {
                var eletronica = (Eletronica) e; // atribuição apenas porque "(Eletronica) e" não é um statement
                return true;
            } catch (ClassCastException exp) {
                return false;
            }

        }).map(Conta::getSaldo).reduce(0.0, Double::sum);
        System.out.println(saldoTotalOnline);

        try (FileWriter fw = new FileWriter(new File("resources/saldoTotalOnline.txt"))) {
            fw.write("" +saldoTotalOnline);
        } // autoclosed

    }
}
