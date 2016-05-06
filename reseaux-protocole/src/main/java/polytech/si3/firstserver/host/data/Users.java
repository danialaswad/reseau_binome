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
        initialize();
    }

    public void initialize(){
        list = new ArrayList();
        list.add(new UserData(1,"danial","aswad","danialaswad@outlook.com","007"));
        list.add(new UserData(1,"david","borry","david.borry@sfr.fr","069"));
    }

    public boolean contains(UserData user){
        return list.contains(user);
    }

    public void add(UserData user){
        list.add(user);
    }

    public void connect(UserData user, String adress){
            UserData userData = find(user);
            userData.connect(adress);
    }

    public UserData find(UserData userData){
        return list.get(list.indexOf(userData));
    }

    @Override
    public String toString(){
        String s = "TYPE | NAME | SURNAME | EMAIL | ID\n";
        for(int i = 0; i < list.size(); i++)
           s+= list.get(i).toString() + "\n";
        return s;

    }
}
