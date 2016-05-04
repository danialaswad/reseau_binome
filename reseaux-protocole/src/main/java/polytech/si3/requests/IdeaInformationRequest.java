package polytech.si3.requests;

/**
 * A idea information request
 * @author Gunther
 *
 */
public class IdeaInformationRequest extends IdeaRequest {

    /**
     * Radom serial number
     */
    private static final long serialVersionUID = -3548365244980876898L;

    /**
     * Instantiates a new idea information request with a given idea id
     * @param id The idea id
     */
    public IdeaInformationRequest(int id) {
        super(id);
    }

    public RequestType requestType() {
        return RequestType.IDEA_INFOROMATION;
    }

}
