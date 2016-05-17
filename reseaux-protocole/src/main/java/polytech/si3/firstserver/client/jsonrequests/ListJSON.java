package polytech.si3.firstserver.client.jsonrequests;

import org.json.JSONException;

/**
 * Created by david on 17/05/2016.
 */
public class ListJSON extends JSONRequest {

    public ListJSON(){
        super();
        this.action = "LIST";

        build();
    }

    @Override
    public void build(){
        try {
            request.put("action", action);
            request.put("data", data);
        }

        catch (JSONException e){
            e.printStackTrace();
        }
    }
}
