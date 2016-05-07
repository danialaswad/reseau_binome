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
        list.add(new UserData(1,"david","borry","david.borry@sfr.fr","69"));
    }

    public boolean contains(UserData user){
        return list.contains(user);
    }

    public void add(UserData user){
        list.add(user);
    }

    public void connect(UserData user, String adress){
            endConnexion(adress);
            UserData userData = find(user);
            userData.connect(adress);
    }

    public void endConnexion(String adress){
        try{
            list.get(list.indexOf(findAdress(adress))).endConnexion();
        }

        catch(Exception e){
           // System.err.println(e);
        }
    }

    public UserData find(UserData userData){
        return list.get(list.indexOf(userData));
    }

    public UserData findAdress(String adress){
        for(int i = 0; i < list.size(); i++)
            if(list.get(i).getAdress().equals(adress))
                return list.get(i);

        return null;
    }

    public UserData findID(String id){
        for(int i = 0; i < list.size(); i++)
            if(list.get(i).id().equals(id))
                return list.get(i);

        return null;
    }

    @Override
    public String toString(){
        String s = "TYPE | NAME | SURNAME | EMAIL | ID\n";
        for(int i = 0; i < list.size(); i++)
           s+= list.get(i).toString() + "\n";
        return s;

    }
}
