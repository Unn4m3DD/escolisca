package myUtilAula2;

import java.util.ArrayList;
import java.util.Collections;

public class OrderList extends ArrayList<Order> {
    public Order getOrderById(int id){
        for(Order o : this){
            if(o.getId() == id){
                return o;
            }
        }
        return null;
    }
    public boolean addOrder(Order order){
        //if(this.contains(order)) return false;
        this.add(order);
        return true;
    }
    public String listOrders(){
        return listOrders("", -1);
    }
    public String listOrders(String filter, int user){
        String result = Order.getHeader();
        for(Order o: this){
            if((filter.equals("") || o.getStatus() == (filter.equals("true"))) ||
                    (user == -1 || o.getClientId() == user))
                result += o.toString() + "\n";
        }
        return result;
    }
    public boolean updateOrder(int clientId, int movieId, int rating, Movie movie){
        for(Order o: this){
            if(o.getClientId() == clientId && o.getMovieId() == movieId)
                return o.updateStatus(rating, movie);

        }
        return false;
    }
}
