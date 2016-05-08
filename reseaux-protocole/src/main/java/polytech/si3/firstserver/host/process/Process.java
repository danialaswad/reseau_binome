package polytech.si3.firstserver.host.process;

import polytech.si3.firstserver.host.data.UserData;
import polytech.si3.firstserver.host.data.Users;
import polytech.si3.replies.Error;
import polytech.si3.replies.Reply;

/**
 * Created by david on 07/05/2016.
 */
public abstract class Process {

    protected Users users;
    protected String adress;
    protected UserData userData;

    protected Error error;

    public Process(Users users, String adress){
        this.userData = users.findAdress(adress);
        this.users=users;
        this.adress=adress;
    }

    public boolean checkAuthentified(){
        return userData != null;
    }

    public void printError(){
        try{
            System.out.println(error.errorType() + " : " + error.reason());
        }

        catch(Exception e){
            System.out.println("NONE");
        }
    }

    public abstract Reply process();
}
