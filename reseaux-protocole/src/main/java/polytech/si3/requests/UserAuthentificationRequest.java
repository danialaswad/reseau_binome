package polytech.si3.requests;

import polytech.si3.User;

/**
 * A user auth request
 * @author Gunther
 *
 */
public class UserAuthentificationRequest implements Request {

    /**
     * Random serial version uid
     */
    private static final long serialVersionUID = 1102738652796908172L;

    private final User user;
    
    /**
     * Instantiates a new user auth request with the given parameters
     * @param user The user
     */
    public UserAuthentificationRequest(User user) {
        this.user = user;
    }

    public RequestType requestType() {
        return RequestType.USER_AUTHENTIFICATION;
    }
    
    public User user() {
        return user;
    }
}
