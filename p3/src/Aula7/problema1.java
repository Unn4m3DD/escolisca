package Aula7;

import myUtilAula7.Companhia;
import myUtilAula7.Hora;
import myUtilAula7.Voo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.Format;
import java.util.*;
import java.util.stream.Collectors;

public class problema1 {
    static Scanner k = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        HashMap<String, String> listaCompanhias = new HashMap<>();
        var listaVoos = new ArrayList<Voo>();
        File f = new File("companhias.txt");
        Scanner fs = new Scanner(f);
        if (fs.hasNextLine()) fs.nextLine();
        while (fs.hasNextLine()) {
            String[] line = fs.nextLine().split("\t");
            listaCompanhias.put(line[0], line[1]);
        }
        fs.close();
        f = new File("voos.txt");
        fs = new Scanner(f);
        if (fs.hasNextLine()) fs.nextLine();
        while (fs.hasNextLine()) {
            String[] line = fs.nextLine().split("\t");
            listaVoos.add(new Voo(new Hora(line[0]), line[1], line[2], new Hora(line.length == 4 ? line[3] : "00:00")));

        }
        fs.close();
        f = new File("Infopublico.txt");
        FileWriter fw = new FileWriter(f);
        String formatter = "%-7.7s%-11.11s%-21.21s%-23.23s%-9.9s%-20.20s";

        System.out.println(String.format(formatter, "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs"));
        fw.write(String.format(formatter, "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs") + "\n");
        listaVoos.stream().forEach((elem) -> {
            String s = String.format(formatter,
                    elem.getHora(),
                    elem.getId(),
                    listaCompanhias.get(elem.getId().substring(0, 2)),
                    elem.getOrigem(),
                    elem.getAtraso(),
                    "Hora Prevista: " + (elem.getHora().add(elem.getAtraso())));
            System.out.println(s);
            try {
                fw.write(s + "\n");
            } catch (Exception e) {
                System.out.println(e);
                System.exit(-1);
            }
        });
        fw.close();
        class CompanhiaEAtraso {
            String companhia;
            int atrasoMedio;

            public CompanhiaEAtraso(String companhia, int atrasoMedio) {
                this.companhia = companhia;
                this.atrasoMedio = atrasoMedio;
            }
        }
        ;
        var atrasosPorCompanhia = new ArrayList<CompanhiaEAtraso>();
        for (String key : listaCompanhias.keySet()) {
            var wrapper = new Object() {
                int totalMinutos = 0;
            };
            var filteredStream = listaVoos.stream().filter(e -> e.getId().substring(0, 2).equals(key));
            var len = (int) filteredStream.count();
            filteredStream = listaVoos.stream().filter(e -> e.getId().substring(0, 2).equals(key));
            filteredStream.forEach(e -> {
                wrapper.totalMinutos += e.getAtraso().getHora();
            });
            atrasosPorCompanhia.add(new CompanhiaEAtraso(
                    listaCompanhias.get(key),
                    (int) wrapper.totalMinutos / (int) len
            ));
        }
        atrasosPorCompanhia.stream()
                .filter(e -> e.atrasoMedio != 0)
                .sorted((e1, e2) -> Integer.compare(e1.atrasoMedio, e2.atrasoMedio))
                .forEach(e -> {
                    System.out.println("Companhia " + e.companhia + ": " + e.atrasoMedio + "min");
                });

        class VoosCidadeCount {
            String cidade;
            int count;

            public VoosCidadeCount(String cidade, int count) {
                this.cidade = cidade;
                this.count = count;
            }
        }
        ArrayList<VoosCidadeCount> voosPorCidade = new ArrayList<>();
        for (var i : listaVoos) {
            var origem = i.getOrigem();
            var brk = false;
            for (var j : voosPorCidade) {
                if (origem.equals(j.cidade)) {
                    brk = true;
                    break;
                }
            }
            if(brk) continue;
            int count = (int) listaVoos.stream().filter(e -> e.getOrigem().equals(origem)).count();
            voosPorCidade.add(new VoosCidadeCount(origem, count));
        }
        f = new File("cidades.txt");
        try (var fww = new FileWriter(f)) {
            fww.write(String.format("%-15.15s %-5.5s\n", "Origem", "Voos"));
            voosPorCidade.stream().sorted((e2, e1) -> Integer.compare(e1.count, e2.count)).forEach(e -> {
                try {
                    fww.write(String.format("%-15.15s %-5.5s\n", e.cidade, e.count));
                } catch (Exception exp) {
                }
                ;
            });

        }
        RandomAccessFile raf = new RandomAccessFile("Infopublico.bin", "rw");
        var w = new Object(){int pos = 0;};
        System.out.println(String.format(formatter, "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs"));
        raf.seek(w.pos);
        raf.write((String.format(formatter, "Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs") + "\n").getBytes());
        w.pos += 92;
        listaVoos.forEach((elem) -> {
            String s = String.format(formatter,
                    elem.getHora(),
                    elem.getId(),
                    listaCompanhias.get(elem.getId().substring(0, 2)),
                    elem.getOrigem(),
                    elem.getAtraso(),
                    "Hora Prevista: " + (elem.getHora().add(elem.getAtraso())));
            System.out.println(s);
            if(w.pos >= 1000)
                System.out.printf("");
            try {
                raf.seek(w.pos);
                String toadd = s + "\n";
                raf.write((toadd).getBytes());
                w.pos += (toadd).getBytes().length;

            } catch (Exception e) {
                System.out.println(e);
                System.exit(-1);
            }
        });
        raf.close();
    }
}
