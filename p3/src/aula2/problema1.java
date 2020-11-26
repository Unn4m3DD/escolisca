package aula2;

import myUtilAula1.*;
import myUtilAula2.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class problema1 {
    static Scanner k = new Scanner(System.in);
    static Store store = new Store();
    static Menu menu = new Menu(new String[]{
            "Gerir Estudantes",
            "Gerir Funcionarios",
            "Gerir Filmes",
            "Interagir"
    });
    static Menu menuGerirEstudantes = new Menu(new String[]{
            "Adicionar Estudantes",
            "Remover Estudantes",
            "Listar Estudantes"
    });
    static Menu menuGerirFuncionarios = new Menu(new String[]{
            "Adicionar Funcionarios",
            "Remover Funcionarios",
            "Listar Funcionarios"
    });
    static Menu menuGerirFilmes = new Menu(new String[]{
            "Adicionar Filmes",
            "Remover Filmes",
            "Listar Filmes",
            "Listar Filmes por Rating"
    });
    static Menu menuInteragir = new Menu(new String[]{
            "Requisitar Filme",
            "Depositar Filme",
            "Listar Historico"
    });

    public static void main(String[] args) {
        int opc = menu.showMenuAndRetrieveOption();
        while (opc != 0) {
            switch (opc) {
                case 1:
                    gerirEstudantes();
                    break;
                case 2:
                    gerirFuncionarios();
                    break;
                case 3:
                    gerirFilmes();
                    break;
                case 4:
                    interagir();
                    break;
            }
            opc = menu.showMenuAndRetrieveOption();
        }
    }


    private static void gerirEstudantes() {
        int opc = menuGerirEstudantes.showMenuAndRetrieveOption();
        if (opc != 0) {
            switch (opc) {
                case 1:
                    adicionarEstudante();
                    break;
                case 2:
                    removerCliente();
                    break;
                case 3:
                    listarEstudantes();
                    break;
            }
        }
    }

    private static void gerirFuncionarios() {
        int opc = menuGerirFuncionarios.showMenuAndRetrieveOption();
        if (opc != 0) {
            switch (opc) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    removerCliente();
                    break;
                case 3:
                    listarFuncionarios();
                    break;
            }
        }
    }

    private static void gerirFilmes() {
        int opc = menuGerirFilmes.showMenuAndRetrieveOption();
        if (opc != 0) {
            switch (opc) {
                case 1:
                    adicionarFilmes();
                    break;
                case 2:
                    removerFilmes();
                    break;
                case 3:
                    listarFilmes();
                    break;
                case 4:
                    listarFilmesRating();
                    break;
            }
        }
    }



    private static void interagir() {
        System.out.println("Introduza o seu id: \n");
        int id = k.nextInt();
        k.nextLine();
        int opc = menuInteragir.showMenuAndRetrieveOption();
        if (opc != 0) {
            switch (opc) {
                case 1:
                    requisitarFilme(id);
                    break;
                case 2:
                    devolverFilme(id);
                    break;
                case 3:
                    listarHistorico(id);
                    break;
            }
        }
    }

    private static void listarHistorico(int id) {
        System.out.println(store.orderList("", id));
    }

    private static void devolverFilme(int id) {
        System.out.println("Insira o id do filme a entregar: \n");
        int movieId = k.nextInt();
        k.nextLine();
        System.out.println("Insira o rating do filme: \n");
        int rating = k.nextInt();
        store.updateOrder(id, movieId, rating);
    }

    private static void requisitarFilme(int id) {
        System.out.println("Insira o id do filme a requisitar: \n");
        int movieId = k.nextInt();
        k.nextLine();
        store.addOrder(new Order(id, movieId));
    }

    private static void listarFilmesRating() {
        System.out.println(store.movieList("", "rating"));
    }

    private static void listarFilmes() {
        System.out.println(store.movieList());
    }

    private static void removerFilmes() {
        System.out.println("Insira o id do filme a eliminar: \n");
        int id = k.nextInt();
        k.nextLine();
        store.removeMovie(id);
    }

    private static void adicionarFilmes() {
        System.out.println("Insira o titulo: \n");
        String nome = k.nextLine();
        System.out.println("Insira o categoria: \n");
        String cat = k.nextLine();
        System.out.println("Escolha categoria de idade (1 : ALL, 2 : M6, 3 : M12, 4 : M16, 5 : M18): \n");
        int age = k.nextInt();
        Movie.AgeRating aget = Movie.AgeRating.ALL;
        k.nextLine();
        switch (age) {
            case 1:
                aget = Movie.AgeRating.ALL;
                break;
            case 2:
                aget = Movie.AgeRating.M6;
                break;
            case 3:
                aget = Movie.AgeRating.M12;
                break;
            case 4:
                aget = Movie.AgeRating.M16;
                break;
            case 5:
                aget = Movie.AgeRating.M18;
                break;
        }
        store.addMovie(new Movie(nome, cat, aget));
    }

    private static void adicionarFuncionario() {
        System.out.println("Insira o seu nome: \n");
        String nome = k.nextLine();
        System.out.println("Insira a sua data de nascimento (dd/mm/aaaa): \n");
        String[] data = k.nextLine().split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);
        Date dataNascimento = new Date(dia, mes, ano);
        System.out.println("Insira o seu nº cc: \n");
        String cc = k.nextLine();
        System.out.println("Insira o seu nif: \n");
        int nif = k.nextInt();
        k.nextLine();
        System.out.println("Insira o seu nº funcionario: \n");
        int nfunc = k.nextInt();
        k.nextLine();
        store.addClient(new Employee(nome,cc,dataNascimento, nif));
    }

    private static void listarFuncionarios() {
        System.out.println(store.clientList("Employee"));
    }

    private static void adicionarEstudante() {
        System.out.println("Insira o seu nome: \n");
        String nome = k.nextLine();
        System.out.println("Insira a sua data de nascimento (dd/mm/aaaa): \n");
        String[] data = k.nextLine().split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);
        Date dataNascimento = new Date(dia, mes, ano);
        System.out.println("Insira o seu nº cc: \n");
        String cc = k.nextLine();
        System.out.println("Insira o seu curso: \n");
        String curso = k.nextLine();
        System.out.println("Insira o seu nº mec: \n");
        int nmec = k.nextInt();
        k.nextLine();
        store.addClient(new Student(nome, cc,dataNascimento, nmec, curso));
    }

    private static void removerCliente() {
        System.out.println("Insira o id do cliente a apagar: \n");
        int id = k.nextInt();
        k.nextLine();
        if (store.removeClient(id)) {
            System.out.println("Cliente Apagado Com Sucesso");
        } else {
            System.out.println("Erro ao Apagar Cliente");
        }
    }

    private static void listarEstudantes() {
        System.out.println(store.clientList("Student"));
    }

}
