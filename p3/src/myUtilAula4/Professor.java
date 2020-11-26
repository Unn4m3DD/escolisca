package myUtilAula4;

import myUtilAula3.Employee;

import java.util.Date;

public class Professor extends Employee {
    Date dataAdmissao;
    public Professor(String name, String cc, Date birthDate, int nif, Date dataAdmissao) {
        super(name, cc, birthDate, nif);
        this.dataAdmissao = dataAdmissao;
    }

    public Professor(String name, String cc, Date dataAdmissao) {
        this(name, cc, new Date(), 0, dataAdmissao);
    }
}
