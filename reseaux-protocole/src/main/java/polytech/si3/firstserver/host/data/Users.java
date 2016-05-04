package polytech.si3.firstserver.host.data;

import polytech.si3.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 04/05/2016.
 */
public class Users {
    private List<UserData> list;

    public Users(){
        list = new ArrayList();
        initialize();
    }

    public void initialize(){
        list.add(new UserData(1,"danial","aswad","danialaswad@outlook.com","007"));
        list.add(new UserData(1,"david","borry","david.borry@sfr.fr","069"));
    }

    public boolean contains(UserData user){
        return list.contains(user);
    }

    public void add(UserData user){
        list.add(user);
    }
}
