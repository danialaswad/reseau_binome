package polytech.si3.replies;

/**
 * An errored reply
 * @author Gunther
 *
 */
public class Error implements Reply {

    /**
     * The serial uid
     */
    private static final long serialVersionUID = 45798485802258744L;
    
    private final ErrorType type;
    private final String reason;
    
    /**
     * Instantiates a new error reply
     * @param type The error type
     * @param reason The error reason
     */
    public Error(ErrorType type, String reason) {
        this.type = type;
        this.reason = reason;
    }
    
    public ReplyType replyType() {
        return ReplyType.ERROR;
    }

    public ErrorType errorType() {
        return type;
    }
    
    public String reason() {
        return reason;
    }
}
