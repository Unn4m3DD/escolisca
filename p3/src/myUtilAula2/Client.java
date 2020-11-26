package myUtilAula2;

import java.util.Date;
import java.util.Objects;

public class Client {
    private int id, maxMovies, currentMovies;
    private Date registerDate, birthDate;
    private String name, cc;
    private static int idCount = 1;

    public Client(String name, String cc, Date birthDate) {
        this.maxMovies = Store.maxMovies;
        this.currentMovies = 0;
        this.name = name;
        this.cc = cc;
        this.registerDate = new Date(System.currentTimeMillis());
        this.birthDate = birthDate;
        this.id = idCount;
        idCount++;
    }
    public boolean canRequest(){
        return currentMovies != maxMovies;
    }
    public boolean currentMoviesInc(){
        if(currentMovies == maxMovies) return false;
        currentMovies++;
        return true;
    }
    public boolean currentMoviesDec(){
        if(currentMovies == 0) return false;
        currentMovies--;
        return true;
    }
    public String getHeader(){
        return "|----------|----------|---|----------|-----|\n"+
               "|      name|        cc| id|      BDay| left|\n"+
               "|----------|----------|---|----------|-----|\n";
    }
    @Override
    public String toString() {
        return String.format(
                "|%10.10s|%10.10s|%3.3s|%10.10s|%5.5s",
                name,
                cc,
                id,
                birthDate.getDay() + "/" + birthDate.getMonth() + "/" + birthDate.getYear(),
                maxMovies-currentMovies);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maxMovies, currentMovies, registerDate, birthDate, name, cc);
    }

    public int getId() {
        return id;
    }

    public int getMaxMovies() {
        return maxMovies;
    }

    public int getCurrentMovies() {
        return currentMovies;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

    public String getCc() {
        return cc;
    }
}
