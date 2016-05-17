package polytech.si3.firstserver.client.jsonrequests;

import polytech.si3.User;

/**
 * Created by david on 11/05/2016.
 */
public class Person extends User {
    private int id;
    private String username, email;

    public Person(int id, String username, String email){
        super(0,username,"",email,""+id);
        this.id=id;
        this.username=username;
        this.email=email;
    }

    public String id(){return ""+id;}
    public String username(){return username;}
    public String email(){return email;};


}
