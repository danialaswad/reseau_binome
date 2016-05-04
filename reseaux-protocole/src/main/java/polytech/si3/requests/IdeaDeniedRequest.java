package polytech.si3.requests;

/**
 * An idea denied request
 * @author Gunther
 *
 */
public class IdeaDeniedRequest extends IdeaRequest {

    /**
     * The serial uid
     */
    private static final long serialVersionUID = -3510100136028851017L;

    private final String reason;
    
    /**
     * Instantiates a new idea denied request
     * @param id The idea id
     * @param reason The deny reason
     */
    public IdeaDeniedRequest(int id, String reason) {
        super(id);
        this.reason = reason;
    }

    public RequestType requestType() {
        return RequestType.IDEA_DENY;
    }

    public String reason() {
        return reason;
    }

}
