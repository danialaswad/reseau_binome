package polytech.si3.firstserver.host.process;

import polytech.si3.firstserver.host.data.UserData;
import polytech.si3.firstserver.host.data.Users;
import polytech.si3.replies.Error;
import polytech.si3.replies.ErrorType;
import polytech.si3.replies.Reply;
import polytech.si3.replies.Success;

/**
 * Created by david on 04/05/2016.
 */
public class Authentification {

    private UserData userData;
    private Users users;
    private String adress;

    public Authentification(UserData userData, Users users, String adress){
        this.userData = userData;
        this.users = users;
        this.adress = adress;
    }

    public Reply process(){
        try{
            System.out.println(userData);
            users.connect(userData,adress);
            return new Success();
        }

       catch(Exception e){
           return new Error(ErrorType.INVALID_USER,"Could not find user");
       }
    }

    public Users users(){
        return users;
    }

}
