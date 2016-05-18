package si3.firstserver.client.builder;

import si3.User;
import si3.requests.*;

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

    /**
     * Creates the AcceptUserRequest type request
     * @param idea
     * @param id
     * @throws NumberFormatException
     */
    public void accept(String idea, String id) throws NumberFormatException{
        request = new AcceptUserRequest(Integer.parseInt(idea), id);
    }

    /**
     * Creates the DenyUserRequest type request
     * @param idea
     * @param id
     * @throws NumberFormatException
     */
    public void deny(String idea, String id) throws NumberFormatException{
        request = new DenyUserRequest(Integer.parseInt(idea),id);
    }

    /**
     * Creates the IdeaCreationRequest type request
     * @param title
     * @param description
     * @param manId
     */
    public void create(String title, String description, String manId){
        request = new IdeaCreationRequest(title, description, manId);
    }

    /**
     * Creates the IdeaDeniedRequest type request
     * @param id
     * @param reason
     * @throws NumberFormatException
     */
    public void reject(String id, String reason) throws NumberFormatException{
        request = new IdeaDeniedRequest(Integer.parseInt(id), reason);
    }

    /**
     * Creates the IdeaInformationRequest type request
     * @param id
     * @throws NumberFormatException
     */
    public void information(String id) throws NumberFormatException{
        request = new IdeaInformationRequest(Integer.parseInt(id));
    }

    /**
     * Creates the IdeaListRequest type request
     */
    public void ideas(){
        request = new IdeaListRequest();
    }

    /**
     * Creates the IdeaValidateRequest type request
     * @param id
     * @throws NumberFormatException
     */
    public void validate(String id) throws NumberFormatException{
        request = new IdeaValidateRequest(Integer.parseInt(id));
    }

    /**
     * Creates the UserListRequest type request
     * @param id
     * @throws NumberFormatException
     */
    public void users(String id) throws NumberFormatException{
        request = new UserListRequest(Integer.parseInt(id));
    }

    /**
     * Creates the UserParticipationRequest type request
     * @param id
     * @throws NumberFormatException
     */
    public void participate(String id) throws NumberFormatException{
        request = new UserParticipationRequest(Integer.parseInt(id));
    }

    /**
     * Getter for the request instance
     * @return
     */
    public Request getRequest(){
        return request;
    }
}
