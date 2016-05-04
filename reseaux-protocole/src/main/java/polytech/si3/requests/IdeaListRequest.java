package polytech.si3.requests;

/**
 * A idea list request
 * @author Gunther
 *
 */
public class IdeaListRequest implements Request {

    /**
     * Random serial id
     */
    private static final long serialVersionUID = -2274018877670062584L;

    public RequestType requestType() {
        return RequestType.IDEA_LIST;
    }

}
