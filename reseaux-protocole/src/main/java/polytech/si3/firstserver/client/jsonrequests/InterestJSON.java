package polytech.si3.firstserver.client.jsonrequests;

import org.json.JSONException;

/**
 * Created by david on 17/05/2016.
 */
public class InterestJSON extends JSONRequest {
    private int id;

    public InterestJSON(int id){
        super();
        this.id = id;
        this.action = "INTEREST";

        build();
    }

    @Override
    public void build(){
        try{
            request.put("action",action);

            data.put("id",id);
            request.put("data",data);
        }

        catch(JSONException e){
            e.printStackTrace();
        }

    }
}
