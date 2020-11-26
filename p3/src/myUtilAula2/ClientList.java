package myUtilAula2;

import java.util.ArrayList;
import java.util.Date;

public class ClientList extends ArrayList<Client> {
    public Client getClientById(int id){
        for(Client c : this){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }
    public boolean addClient(Client client){
        //if(this.contains(client)) return false;
        this.add(client);
        return true;
    }

    public String listClients(){
        return listClients("");
    }
    public String listClients(String filter){
        Client obj;
        if(filter.equals("Student"))
            obj = new Student("","",new Date(0),0,"");
        else if(filter.equals("Employee"))
            obj = new Employee("","",new Date(0),0);
        else
            obj = new Client("","",new Date(0));
        String result = obj.getHeader();
        for(Client c: this){
            if((filter.equals("Student") && !(c instanceof Student)) || (filter.equals("Employee") && !(c instanceof Employee)))
                continue;
            result += c.toString() + "\n";
        }
        return result;
    }
}
