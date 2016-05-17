package polytech.si3.firstserver.client.jsonrequests;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringWriter;

/**
 * Created by david on 17/05/2016.
 */
public abstract class JSONRequest {

    protected String action;
    protected JSONObject data, request;

    public JSONRequest(){
        data = new JSONObject();
        request = new JSONObject();
    }
    public abstract void build();

    public String printRequest() throws JSONException {
        StringWriter out = new StringWriter();
        request.write(out);

        String jsonText = out.toString();
        return jsonText;
    }
}
