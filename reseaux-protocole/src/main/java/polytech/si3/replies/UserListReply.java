package polytech.si3.replies;

import java.util.List;

import polytech.si3.User;

/**
 * List of users reply
 * @author Gunther
 *
 */
public class UserListReply implements Reply {

    /**
     * The serial uid
     */
    private static final long serialVersionUID = 4230036102197184935L;
    
    private final List<User> users;
    
    /**
     * Instantiates a new user list reply
     * @param users The given user list
     */
    public UserListReply(List<User> users) {
        this.users = users;
    }
    
    public ReplyType replyType() {
        return ReplyType.USER_LIST;
    }
    
    public List<User> users() {
        return users;
    }

}
