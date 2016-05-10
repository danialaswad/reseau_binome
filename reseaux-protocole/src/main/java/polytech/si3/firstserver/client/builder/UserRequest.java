package polytech.si3.firstserver.client.builder;

/**
 * Created by danialaswad on 10/05/2016.
 */
public enum UserRequest {

    /**
     * User authentification
     */
    AUTHENTIFICATION("user authentification", "user"),

    /**
     * Idea creation
     */
    CREATE("Create an idea", "create [title] [description] [manager id]"),

    /**
     * Idea list
     */
    IDEAS("List of ideas", "ideas"),

    /**
     * Idea information
     */
    INFORMATION("Get the information of an idea", "information [idea id]"),

    /**
     * User participation
     */
    PARTICIPATE("Participate to an idea", "participate [idea id]"),

    /**
     * A user list from an idea
     */
    USERS("List of users in an idea", "users [idea id]"),

    /**
     * Idea validation
     */
    VALIDATE("Validate an idea", "validate [idea id]"),

    /**
     * Deny user from an idea
     */
    DENY("Deny a user from an idea", "deny [idea id] [user id]"),

    /**
     * Accept user from an idea
     */
    ACCEPT("Accept a user in an idea", "accept [idea id] [user id]"),

    /**
     * Idea deny
     */
    REJECT("Reject an idea", "reject [idea id] [reason]");

    private String descrition;
    private String manual;

    UserRequest(String descrition, String manual){
        this.manual = manual;
        this.descrition = descrition;
    }

    public String getDescrition(){
        return descrition;
    }

    public String getManual(){
        return manual;
    }
}
