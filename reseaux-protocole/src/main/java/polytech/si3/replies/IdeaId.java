package polytech.si3.replies;

/**
 * Idea id
 * @author Gunther
 *
 */
public class IdeaId extends AbstractIdeaIdReply {

    /**
     * Serial id
     */
    private static final long serialVersionUID = 5537275146774792664L;

    public IdeaId(int id) {
        super(id);
    }

    public ReplyType replyType() {
        return ReplyType.IDEA_ID;
    }

}
