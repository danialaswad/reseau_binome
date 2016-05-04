package polytech.si3.requests;

/**
 * A user list request
 * @author Gunther
 *
 */
public class UserListRequest extends IdeaRequest {

    /**
     * The serial uid
     */
    private static final long serialVersionUID = 2032979328846551989L;

    /**
     * Instantiates a new user list request from an idea
     * @param id The idea id
     */
    public UserListRequest(int id) {
        super(id);
    }

    public RequestType requestType() {
        return RequestType.USER_LIST_FROM_IDEA;
    }

}
