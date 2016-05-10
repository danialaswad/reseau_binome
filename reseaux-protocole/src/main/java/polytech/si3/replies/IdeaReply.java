package polytech.si3.replies;

import java.util.List;

import polytech.si3.User;

/**
 * An idea reply
 * @author Gunther
 *
 */
public class IdeaReply extends IdeaPreviewReply {

    /**
     * The serial id
     */
    private static final long serialVersionUID = -3008322722627545808L;
    
    private final String description;
    
    private final List<User> interested, participants;

    /**
     * Instantiates a new idea preview with the given parameters
     * @param id The idea id
     * @param status The idea status
     * @param author The idea author
     * @param manager The idea manager
     * @param title The idea title
     * @param description The idea description
     * @param participants The participants
     * @param interested The interested users
     */
    public IdeaReply(int id, int status, User author, User manager, String title, String description, List<User> interested, List<User> participants) {
        super(id, status, author, manager, title);
        this.description = description;
        this.interested = interested;
        this.participants = participants;
    }

    @Override
    public ReplyType replyType() {
        return ReplyType.IDEA;
    }

    public String description() {
        return description;
    }
    
    public List<User> interested() {
        return interested;
    }
    
    public List<User> participants() {
        return participants;
    }
}
