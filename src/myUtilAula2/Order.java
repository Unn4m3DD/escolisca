package myUtilAula2;

public class Order {
    private int id, clientId, movieId;
    private static int idCount = 1;
    private boolean status;

    public Order(int clientId, int movieId) {
        this.id = idCount;
        this.clientId = clientId;
        this.movieId = movieId;
        this.status = false;
        idCount++;
    }

    public static String getHeader(){
        return  "|-----|----------|-----|-----------|\n"+
                "|   id| Client Id|Movie|     Status|\n"+
                "|-----|----------|-----|-----------|\n";
    }

    @Override
    public String toString() {
        return String.format("|%5.5s|%10.10s|%5.5s|%11.11s|",
                id,
                clientId,
                movieId,
                status
        );
    }
    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public int getMovieId() {
        return movieId;
    }

    public boolean getStatus(){
        return  status;
    }

    public boolean updateStatus(int rating, Movie m){
        if(!m.rate(rating)) return false;
        this.status = true;
        return true;
    }
}
