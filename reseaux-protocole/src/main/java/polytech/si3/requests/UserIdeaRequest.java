package polytech.si3.requests;

/**
 * an abstract user idea request
 * @author Gunther
 *
 */
public abstract class UserIdeaRequest extends IdeaRequest {

    /**
     * The serial uid
     */
    private static final long serialVersionUID = 2293408738627846012L;
    
    private final String userId;
    
    /**
     * Instantiates a new accept user request for an idea
     * @param ideaId The idea id
     * @param userId The user id
     */
    public UserIdeaRequest(int ideaId, String userId) {
        super(ideaId);
        this.userId = userId;
    }
    
    public String userId() {
        return userId;
    }

}
