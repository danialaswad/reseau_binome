package polytech.si3.replies;

import java.io.Serializable;

/**
 * A simple reply interface
 * 
 * @author Gunther
 *
 */
public interface Reply extends Serializable {

    /**
     * 
     * @return The type of the reply
     */
    public ReplyType replyType();
}
