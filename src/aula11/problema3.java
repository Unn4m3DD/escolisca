package aula11;

import myUtilAula6.*;

import java.io.*;
import java.util.Random;

public class problema3 {

    public static void main(String[] args) throws Exception {
        Ementa ementa = new Ementa("Especial Caloiro", "Snack da UA");
        Prato[] pratos = new Prato[10];
        for (int i = 0; i < pratos.length; i++) {
            pratos[i] = randPrato(i);
            int cnt = 0;
            while (cnt < 2) { // Adicionar 2 Ingredientes a cada Prato
                Alimento aux = randAlimento();
                if (pratos[i].addIngrediente(aux)) {
                    System.out.println("Adicionado '" +
                            aux + "' ao -> " + pratos[i]);
                    cnt++;
                } else
                    System.out.println("ERRO: Não é possivel adicionar '" +
                            aux + "' ao -> " + pratos[i]);
            }
            Random r = new Random();
            ementa.addPrato(pratos[i], r.nextInt(6)); // Dia Aleatório
        }
        System.out.println("\n" + ementa);
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("ementa");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(ementa);
            out.close();
            fileOut.close();
            System.out.print("Serialized data is saved in ementa");
        } catch (IOException i) {
            i.printStackTrace();
        }

        try {
            FileInputStream fileIn = new FileInputStream("ementa");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ementa = (Ementa) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("\n" + ementa);
    }

    // Retorna um Alimento Aleatoriamente
    public static Alimento randAlimento() {
        switch ((int) (Math.random() * 4)) {
            default:
            case 0:
                return new Carne(22.3, 345.3, 300, Carne.Variedade.frango);
            case 1:
                return new Peixe(31.3, 25.3, 200, Peixe.Tipo.congelado);
            case 2:
                return new Legume(21.3, 22.4, 150, "Couve Flor");
            case 3:
                return new Cereal(19.3, 32.4, 110, "Milho");
        }
    }

    // Retorna um Tipo de Prato Aleatoriamente
    public static Prato randPrato(int i) {
        switch ((int) (Math.random() * 3)) {
            default:
            case 0:
                return new Prato("Prato N." + i);
            case 1:
                return new PratoVegetariano("Prato N." + i + " (Vegetariano)");
            case 2:
                return new PratoDieta("Prato N." + i + " (Dieta)", 90.8);
        }
    }
}
