package polytech.si3.firstserver.client.builder.json;

import polytech.si3.firstserver.client.builder.Builder;
import polytech.si3.firstserver.client.jsonrequests.*;

/**
 * Created by david on 11/05/2016.
 * Creates JSON requests for Server
 */
public class JSONBuilder  {

    private Person person;
    private JSONRequest request;

    public JSONBuilder(Person person){
        this.person=person;
    }

    public void interest(int id){
        request = new InterestJSON(id);
    }

    public void list(){

        request = new ListJSON();
    }

    public void join(int id){
        request = new JoinJSON(id,person);
    }

    public void add(int id, String name, String description, String technology){
        System.out.println("addqsdqsd");
        request = new AddJSON(id,name,description,technology,person);
    }

    public JSONRequest getRequest(){
        return request;
    }
}
