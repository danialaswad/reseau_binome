package polytech.si3.firstserver.client;

import polytech.si3.User;
import polytech.si3.requests.Request;
import polytech.si3.requests.UserAuthentificationRequest;

/**
 * Created by danialaswad on 03/05/2016.
 */
public class RequestBuilder {

    private User user;
    private Request request;

    public RequestBuilder(User user){
        this.user = user;
    }

    /**
     * Build the request
     */
    public void build(){
        // To do
        request = new UserAuthentificationRequest(user);
    }

    /**
     * @return Request
     */
    public Request getRequest(){
        return request;
    }
}
