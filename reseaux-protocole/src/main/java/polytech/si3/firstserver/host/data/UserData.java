package polytech.si3.firstserver.host.data;

import polytech.si3.User;

public class UserData {

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
    public UserData(int type, String name, String surname, String email, String id) {
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.id = id;
    }

    public UserData(User user){
        this.type = user.type();
        this.name = user.name();
        this.surname = user.surname();
        this.email = user.email();
        this.id = user.id();
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

    @Override
    public boolean equals(Object o){

        try{
            UserData userData = (UserData) o;
            boolean eq = (this.type == userData.type
                            && this.name.equals(userData.name)
                            && this.surname.equals(userData.surname)
                            && this.email.equals(userData.email)
                            && this.id.equals(userData.id));
            return eq;
        }

        catch(Exception e){
            return false;
        }
    }
}
