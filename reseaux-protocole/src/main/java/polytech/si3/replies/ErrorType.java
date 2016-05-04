package polytech.si3.replies;

public enum ErrorType {

    /**
     * Not authenticated
     */
    NOT_AUTHENTICATED,
    /**
     * Invalid user
     */
    INVALID_USER,
    
    /**
     * Invalid manager
     */
    INVALID_MANAGER,
    
    /**
     * Invalid idea title
     */
    INVALID_TITLE,
    
    /**
     * Too many ideas
     */
    TOO_MANY_IDEAS,
    
    /**
     * Idea not found
     */
    IDEA_NOT_FOUND,
    
    /**
     * Too many users in the idea
     */
    TOO_MANY_USERS,
    
    /**
     * Idea already started (status)
     */
    IDEA_HAS_BEEN_STARTED,
    
    /**
     * No permission
     */
    NO_PERMISSION,
    
    
}
