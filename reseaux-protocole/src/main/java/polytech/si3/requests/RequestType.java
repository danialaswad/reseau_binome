package polytech.si3.requests;

/**
 * The different request types
 * @author Gunther
 *
 */
public enum RequestType {

    /**
     * User authentification
     */
    USER_AUTHENTIFICATION,
    
    /**
     * Idea creation
     */
    IDEA_CREATION,
    
    /**
     * Idea list
     */
    IDEA_LIST,
    
    /**
     * Idea information
     */
    IDEA_INFOROMATION,
    
    /**
     * User participation 
     */
    USER_PARTICIPATION,
    
    /**
     * A user list from an idea
     */
    USER_LIST_FROM_IDEA,
    
    /**
     * Idea validation 
     */
    IDEA_VALIDATION,
    
    /**
     * Idea deny
     */
    IDEA_DENY,
    
    /**
     * Accept user from an idea
     */
    ACCEPT_USER,
    
    /**
     * Deny user from an idea
     */
    DENY_USER
    ;
}