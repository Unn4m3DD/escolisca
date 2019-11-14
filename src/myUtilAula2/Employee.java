package myUtilAula2;

import java.util.Date;

public class Employee extends Client {
    private int employeeId, nif;
    private static int emploeyeeIdCount = 1;

    public Employee(String name, String cc, Date birthDate, int nif) {
        super(name, cc, birthDate);
        this.employeeId = emploeyeeIdCount;
        this.nif = nif;
        emploeyeeIdCount++;
    }
    public String getHeader(){
        return  "|----------|----------|---|----------|-----|------|-----------|\n"+
                "|      name|        cc| id|      BDay| left|Emp Id|        NIF|\n"+
                "|----------|----------|---|----------|-----|------|-----------|\n";
    }
    @Override
    public String toString() {
        return super.toString() + String.format("%6.6s|%10.10s|",employeeId, nif);
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public int getNif() {
        return nif;
    }

}
