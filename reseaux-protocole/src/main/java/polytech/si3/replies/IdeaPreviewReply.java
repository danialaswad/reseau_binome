package polytech.si3.replies;

import polytech.si3.User;

/**
 * An idea preview
 * @author Gunther
 *
 */
public class IdeaPreviewReply extends AbstractIdeaIdReply {

    /**
     * The serial uid
     */
    private static final long serialVersionUID = 2673015365577440345L;
    
    /**
     * 0 = waiting for members
     * 1 = started
     * 2 = denied
     */
    private final int status;
    private final User author, manager;
    private final String title;
    
    /**
     * Instantiates a new idea preview with the given parameters
     * @param id The idea id
     * @param status The idea status
     * @param author The idea author
     * @param manager The idea manager
     * @param title The idea title
     */
    public IdeaPreviewReply(int id, int status, User author, User manager, String title) {
        super(id);
        this.status = status;
        this.author = author;
        this.manager = manager;
        this.title = title;
    }

    public ReplyType replyType() {
        return ReplyType.IDEA_PREVIEW;
    }
    
    public int status() {
        return status;
    }
    
    public User author() {
        return author;
    }
    
    public User manager() {
        return manager;
    }
    
    public String title() {
        return title;
    }
}
