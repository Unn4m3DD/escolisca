package myUtilAula3;

import java.util.Date;

public class Student extends Client {
    private int nMec;
    public static int nMecCount = 1;
    private String course;

    public Student(String name, String cc, Date birthDate) {
        super(name, cc, birthDate);
        this.nMec = nMecCount;
        nMecCount++;
        this.course = "";
    }
    public String getHeader(){
        return "|----------|----------|---|----------|-----|------|\n"+
               "|      name|        cc| id|      BDay| left|nº Mec|\n"+
               "|----------|----------|---|----------|-----|------|\n";
    }
    @Override
    public String toString() {
        return super.toString() + String.format("|%6.6s|%7.7s|",nMec, course);
    }
    public int getnMec() {
        return nMec;
    }

    public String getCourse() {
        return course;
    }
}
