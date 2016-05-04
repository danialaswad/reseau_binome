package polytech.si3;

import java.io.Serializable;

public class User implements Serializable {

    /**
     * The serial uid
     */
    private static final long serialVersionUID = -8174034219607663091L;
    
    private final int type;
    private final String name, surname, email, id;
    
    /**
     * Instantiates a new user 
     * @param type The user type
     * @param name The user's name
     * @param surname The user's surname
     * @param email The user's email
     * @param id The user's id
     */
    public User(int type, String name, String surname, String email, String id) {
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.id = id;
    }

    public int type() {
        return type;
    }

    public String name() {
        return name;
    }
    
    public String surname() {
        return surname;
    }
    
    public String email() {
        return email;
    }
    
    public String id() {
        return id;
    }
}
