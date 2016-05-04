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

    public Authentification(UserData userData, Users users){
        this.userData = userData;
        this.users = users;
    }

    public Reply process(){
        if(users.contains(userData))
            return new Success();

        return new Error(ErrorType.INVALID_USER,"Could not find user");
    }

}
