package polytech.si3.firstserver.client.jsonrequests;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 17/05/2016.
 */
public class JoinJSON extends JSONRequest {

    private int id;
    private Person person;

    public JoinJSON(int id, Person person){
        super();

        this.id=id;
        this.person=person;

        build();
    }

    @Override
    public void build(){
        try{
            request.put("action",action);

            data.put("id",id);
            JSONObject personJSON = new JSONObject();
            personJSON.put("id",person.id());
            personJSON.put("username",person.username());
            personJSON.put("email",person.email());
            data.put("person",personJSON);

            request.put("data",data);
        }

        catch (JSONException e){
            e.printStackTrace();
        }
    }
}
