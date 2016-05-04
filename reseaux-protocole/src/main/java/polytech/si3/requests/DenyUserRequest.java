package polytech.si3.requests;

/**
 * Deny user request
 * @author Gunther
 *
 */
public class DenyUserRequest extends UserIdeaRequest {

    /**
     * The serial uid
     */
    private static final long serialVersionUID = 4197033236316132042L;

    /**
     * Instantiates a new deny user request for an idea
     * @param ideaId The idea id
     * @param userId The user id
     */
    public DenyUserRequest(int ideaId, int userId) {
        super(ideaId, userId);
    }

    public RequestType requestType() {
        return RequestType.DENY_USER;
    }

}
