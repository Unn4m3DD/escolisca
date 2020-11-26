package myUtilAula1;

import java.util.Scanner;

public class Menu {
    String[] options;

    public Menu(String[] options) {
        this.options = options;
    }

    public int showMenuAndRetrieveOption(){
        for(int i = 1; i <= options.length; i++){
            System.out.println(i + " - " + options[i - 1]);
        }
        System.out.println("0 - exit");
        return new Scanner(System.in).nextInt();
    }
}
