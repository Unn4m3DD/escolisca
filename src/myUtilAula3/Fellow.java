package myUtilAula3;

import java.util.Date;
import java.util.Objects;

public class Fellow extends Student {
    private int amount;

    public Fellow(String name, String cc, Date birthDate) {
        super(name, cc, birthDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fellow fellow = (Fellow) o;
        return amount == fellow.amount;
    }
    public String getHeader(){
        return  "|----------|----------|---|----------|-----|------|-------|--------|\n"+
                "|      name|        cc| id|      BDay| left|nº Mec| course|  amount|\n"+
                "|----------|----------|---|----------|-----|------|-------|--------|\n";
    }
    public void setBolsa(int amount){
        this.amount = amount;
    }
    public int getBolsa(){
        return amount;
    }
    @Override
    public String toString() {
        return super.toString() + String.format("|%8.8s|", amount);
    }
}
