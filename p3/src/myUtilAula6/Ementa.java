package myUtilAula6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Ementa implements Serializable {
    String nome, local;
    ArrayList<Prato>[] listaPratosSemana = new ArrayList[7];

    public Ementa(String nome, String local) {
        this.nome = nome;
        this.local = local;
        for(int i = 0; i < 7; i++)
            listaPratosSemana[i] = new ArrayList<Prato>();
    }

    public void addPrato(Prato p, int d) {
        listaPratosSemana[d].add(p);
    }
    public void remPrato(Prato p, int d) {
        listaPratosSemana[d].remove(p);
    }
    public void addIngrediente(Alimento a,int dia, int index) {
        listaPratosSemana[dia].get(index).addIngrediente(a);
    }

    public String getEmentaDia(int dia){
        return listaPratosSemana[dia].toString();
    }
    @Override
    public String toString() {
        return "Ementa{" +
                "nome='" + nome + '\'' +
                ", local='" + local + '\'' +
                ", listaPratosSemana=" + Arrays.toString(listaPratosSemana) +
                '}';
    }
}
