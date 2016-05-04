package polytech.si3.firstserver.host;

import polytech.si3.replies.Reply;
import polytech.si3.replies.Success;
import polytech.si3.requests.Request;

/**
 * Created by danialaswad on 03/05/2016.
 */
public class RequestHandler {

    private Request request;
    private Reply response;

    public RequestHandler(Object object){
        this.request = (Request) object;
    }

    /**
     * Method call for interpreting the request
     */
    public void readRequest(){
        // To do
        System.out.println(request.requestType());
    }

    /**
     * Method call for response
     * @return Reply response to the request
     */
    public Object response(){
        // To do
        return response = new Success();
    }
}
