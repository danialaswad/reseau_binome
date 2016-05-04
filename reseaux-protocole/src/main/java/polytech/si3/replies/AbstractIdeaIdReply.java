package polytech.si3.replies;

/**
 * An abstract idea id reply
 * @author Gunther
 *
 */
public abstract class AbstractIdeaIdReply implements Reply {

    /**
     * The serial uid
     */
    private static final long serialVersionUID = -4505028311379720092L;
    
    private final int id;
    
    /**
     * 
     * @param id The idea id
     */
    public AbstractIdeaIdReply(int id) {
        this.id = id;
    }
    
    public int id() {
        return id;
    }
}
