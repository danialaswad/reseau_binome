package polytech.si3.firstserver.client.builder;

import polytech.si3.User;
import polytech.si3.requests.*;

/**
 * Created by danialaswad on 09/05/2016.
 */
public class Builder {
    private User user;
    private Request request;

    public Builder(User user){
        this.user = user;
    }

    public void authentification(){
        request = new UserAuthentificationRequest(user);
    }

    public void accept(String idea, String id) throws NumberFormatException{
        request = new AcceptUserRequest(Integer.parseInt(idea), id);
    }

    public void deny(String idea, String id) throws NumberFormatException{
        request = new DenyUserRequest(Integer.parseInt(idea),id);
    }

    public void create(String title, String description, String manId){
        request = new IdeaCreationRequest(title, description, manId);
    }

    public void reject(String id, String reason) throws NumberFormatException{
        request = new IdeaDeniedRequest(Integer.parseInt(id), reason);
    }

    public void information(String id) throws NumberFormatException{
        request = new IdeaInformationRequest(Integer.parseInt(id));
    }

    public void ideas(){
        request = new IdeaListRequest();
    }

    public void validate(String id) throws NumberFormatException{
        request = new IdeaValidateRequest(Integer.parseInt(id));
    }

    public void users(String id) throws NumberFormatException{
        request = new UserListRequest(Integer.parseInt(id));
    }

    public void participate(String id) throws NumberFormatException{
        request = new UserParticipationRequest(Integer.parseInt(id));
    }

    public Request getRequest(){
        return request;
    }
}
