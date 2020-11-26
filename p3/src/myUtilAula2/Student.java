package myUtilAula2;

import java.util.Date;

public class Student extends Client {
    private int nMec;
    private String course;

    public Student(String name, String cc, Date birthDate, int nMec, String course) {
        super(name, cc, birthDate);
        this.nMec = nMec;
        this.course = course;
    }
    public String getHeader(){
        return "|----------|----------|---|----------|------|\n"+
               "|      name|        cc| id|      BDay|nº Mec|\n"+
               "|----------|----------|---|----------|------|\n";
    }
    @Override
    public String toString() {
        return super.toString() + String.format("|%6.6s|%7.7s|",nMec, course);
    }
    public int getNMec() {
        return nMec;
    }

    public String getCourse() {
        return course;
    }
}
