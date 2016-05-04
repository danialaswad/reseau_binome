package polytech.si3.replies;

/**
 * A successful reply
 * @author Gunther
 *
 */
public class Success implements Reply {

    /**
     * The serial uid
     */
    private static final long serialVersionUID = -7210736373576565649L;

    public ReplyType replyType() {
        return ReplyType.SUCCESS;
    }

}
