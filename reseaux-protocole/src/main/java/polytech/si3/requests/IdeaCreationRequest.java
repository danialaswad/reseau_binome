package polytech.si3.requests;

/**
 * An idea creation request
 * @author Gunther
 *
 */
public class IdeaCreationRequest implements Request {

    /**
     * Random serial id
     */
    private static final long serialVersionUID = 5391693924177866599L;
    
    private final String title, description;
    private final String managerId;
    
    /**
     * Instantiates a new idea creation request
     * @param title The title of the idea
     * @param description The description of the idea
     * @param managerId The current id of the manager (c.f. User)
     */
    public IdeaCreationRequest(String title, String description, String managerId) {
        this.title = title;
        this.description = description;
        this.managerId = managerId;
    }

    public RequestType requestType() {
        return RequestType.IDEA_CREATION;
    }
    
    public String title() {
        return title;
    }
    
    public String description() {
        return description;
    }
    
    public String managerId() {
        return managerId;
    }

}
