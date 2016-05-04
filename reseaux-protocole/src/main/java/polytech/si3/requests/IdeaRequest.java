package polytech.si3.requests;

/**
 * A simple abstract idea request
 * @author Gunther
 *
 */
public abstract class IdeaRequest implements Request {

    /**
     * Random serial version uid
     */
    private static final long serialVersionUID = -8778126683202697117L;
    
    private final int ideaId;
    
    public IdeaRequest(int id) {
        this.ideaId = id;
    }
    
    public int ideaId() {
        return ideaId;
    }

}
