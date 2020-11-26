package aula3;

import myUtilAula3.Fellow;
import myUtilAula3.Student;

import java.util.Date;

public class problema1 {
        public static void main(String[] args) {
            Student est = new Student ("Andreia", "9855678", new Date(18, 7, 1974));
            Fellow bls = new Fellow ("Maria", "8976543", new Date(11, 5, 1976));
            bls.setBolsa(745);
            System.out.println("Student:" + est.getName());
            System.out.println(est);

            System.out.println("Fellow:" + bls.getName() + ", NMec: " + bls.getnMec()
                    + ", Bolsa:" + bls.getBolsa());
            System.out.println(bls);
    }
}
