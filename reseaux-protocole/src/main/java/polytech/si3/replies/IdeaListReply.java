package polytech.si3.replies;

import java.util.List;

/**
 * An idea list reply
 * @author Gunther
 *
 */
public class IdeaListReply implements Reply {

    /**
     * The serial uid
     */
    private static final long serialVersionUID = 1682163955300523024L;
    
    private final List<IdeaPreviewReply> ideas;
    
    /**
     * Instantiates a new idea list reply
     * @param ideas The list of ideas
     */
    public IdeaListReply(List<IdeaPreviewReply> ideas) {
        this.ideas = ideas;
    }
    
    public ReplyType replyType() {
        return ReplyType.IDEA_LIST;
    }
    
    public List<IdeaPreviewReply> ideas() {
        return ideas;
    }

}
