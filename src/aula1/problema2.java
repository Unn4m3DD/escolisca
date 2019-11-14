package aula1;

import myUtilAula1.Data;
import myUtilAula1.Menu;
import myUtilAula1.Pessoa;

import java.util.*;

public class problema2 {
    private static Scanner k = new Scanner(System.in);
    private static ListaPessoas l = new ListaPessoas();
    private static Menu menu = new Menu(new String[]{
            "Introduzir",
            "Apagar",
            "Mostrar Pessoas",
            "Mostrar Pessoas Ordenadas por CC"
    });

    public static void main(String[] args) throws Exception {
        int opc = menu.showMenuAndRetrieveOption();
        while (opc != 0) {
            switch (opc) {
                case 1:
                    System.out.println("Introduza o nome:");
                    String nome = k.nextLine();
                    System.out.println("Introduza o cc:");
                    int cc = k.nextInt();
                    System.out.println("Introduza a data de nascimento:");
                    k.nextLine();
                    Data nasc = new Data(k.nextLine());
                    l.insert(new Pessoa(nome, cc, nasc));
                    break;
                case 2:
                    System.out.println("Insira o id da pessoa que deseja eliminar (c para cancelar)");
                    String response = k.next();
                    if (response.equals("c")) return;
                    l.delete(Integer.parseInt(response));
                    break;
                case 3:
                    l.showUnordered();
                    break;
                case 4:
                    l.showOrdered();
                    break;
            }
            opc = menu.showMenuAndRetrieveOption();
        }
    }



}
