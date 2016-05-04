package polytech.si3.firstserver.client;

import polytech.si3.replies.Reply;

/**
 * Created by danialaswad on 03/05/2016.
 */
public class ResponseHandler {

    private Reply reply;

    public ResponseHandler(Reply reply){
        this.reply = reply;
    }

    /**
     * Reads the request
     */
    public void read(){
        // To do
        System.out.println(reply.replyType());
    }
}
