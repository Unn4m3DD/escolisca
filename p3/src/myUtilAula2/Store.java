package myUtilAula2;

import java.util.Date;

public class Store {

    public static int maxMovies = 3;
    public ClientList cl = new ClientList();
    public MovieList ml = new MovieList();
    public OrderList ol = new OrderList();

    public Store() {
        cl.addClient(new Student("André", "32312412", new Date(System.currentTimeMillis()),93357, "ct"));
        cl.addClient(new Student("Joao", "12142123", new Date(System.currentTimeMillis()),93257, "ect"));
        cl.addClient(new Student("Maria", "42512522", new Date(System.currentTimeMillis()),91257, "eet"));
        cl.addClient(new Student("Jose", "51123421", new Date(System.currentTimeMillis()),91247, "ct"));
        ml.addMovie(new Movie("sena", "asdasd", Movie.AgeRating.ALL));
        ml.addMovie(new Movie("sdasda2", "safas", Movie.AgeRating.M6));
        ml.addMovie(new Movie("wqewq", "sdfqeqw", Movie.AgeRating.M12));
        ml.addMovie(new Movie("sadds", "afssad", Movie.AgeRating.M16));
    }

    public String clientList(){
        return cl.listClients();
    }
    public String clientList(String filter){
        return cl.listClients(filter);
    }
    public boolean addClient(Client client){
        return cl.addClient(client);
    }
    public boolean removeClient(int id){
        return cl.remove(id) != null;
    }
    public String movieList(){
        return ml.listMovies();
    }
    public String movieList(String filter, String sortBy){
        return ml.listMovies(filter, sortBy);
    }
    public boolean addMovie(Movie movie){
        return ml.addMovie(movie);
    }

    public boolean removeMovie(int id){
        return ml.remove(id) != null;
    }
    public String orderList(){
        return ol.listOrders();
    }
    public String orderList(String filter, int userId){
        return ol.listOrders(filter, userId);
    }
    public boolean addOrder(Order order){
        Client client = cl.getClientById(order.getClientId());
        if(!client.canRequest()) return false;
        client.currentMoviesInc();
        return ol.addOrder(order);
    }
    public boolean updateOrder(int clientId, int movieId, int rating){
        cl.getClientById(clientId).currentMoviesDec();
        return ol.updateOrder(clientId, movieId, rating, ml.getMovieById(movieId));
    }
}
