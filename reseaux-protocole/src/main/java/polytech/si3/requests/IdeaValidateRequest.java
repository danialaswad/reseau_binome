package polytech.si3.requests;

/**
 * An idea validation request
 * @author Gunther
 *
 */
public class IdeaValidateRequest extends IdeaRequest {

    /**
     * The serial uid
     */
    private static final long serialVersionUID = 7005089512638801090L;

    public IdeaValidateRequest(int id) {
        super(id);
    }

    public RequestType requestType() {
        return RequestType.IDEA_VALIDATION;
    }

}
