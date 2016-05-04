package polytech.si3.requests;

/**
 * A user participation request
 * 
 * @author Gunther
 *
 */
public class UserParticipationRequest extends IdeaRequest {

    /**
     * The serial uid
     */
    private static final long serialVersionUID = -6157977449915570894L;

    /**
     * Instantiates a new user participation request
     * @param id The idea id
     */
    public UserParticipationRequest(int id) {
        super(id);
    }

    public RequestType requestType() {
        return RequestType.USER_PARTICIPATION;
    }

}
