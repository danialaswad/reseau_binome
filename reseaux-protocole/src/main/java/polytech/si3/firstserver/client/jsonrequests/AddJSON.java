package polytech.si3.firstserver.client.jsonrequests;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 17/05/2016.
 */
public class AddJSON extends JSONRequest {

    private int id;
    private String name, description, technology;
    private Person person;

    public AddJSON(int id, String name, String description, String technology, Person person){
        this.action = "ADD";
        this.id=id;
        this.name=name;
        this.description=description;
        this.technology=technology;
        this.person=person;

        build();
    }

    @Override
    public void build(){
        try{
            request.put("action",action);

            data.put("id",id);
            data.put("name",name);
            data.put("description",description);
            data.put("technology",technology);

            JSONObject personJSON = new JSONObject();
            personJSON.put("id",person.id());
            personJSON.put("username",person.username());
            personJSON.put("email",person.email());
            data.put("person",personJSON);
            request.put("data",data);
        }

        catch(JSONException e){
            e.printStackTrace();
        }
    }
}
