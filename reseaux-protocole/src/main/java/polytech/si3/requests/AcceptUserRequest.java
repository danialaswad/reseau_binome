package polytech.si3.requests;

/**
 * Accept user request
 * @author Gunther
 *
 */
public class AcceptUserRequest extends UserIdeaRequest {

    /**
     * The serial uid
     */
    private static final long serialVersionUID = 4197033236316132042L;

    /**
     * Instantiates a new accept user request for an idea
     * @param ideaId The idea id
     * @param userId The user id
     */
    public AcceptUserRequest(int ideaId, String userId) {
        super(ideaId, userId);
    }

    public RequestType requestType() {
        return RequestType.ACCEPT_USER;
    }

}
