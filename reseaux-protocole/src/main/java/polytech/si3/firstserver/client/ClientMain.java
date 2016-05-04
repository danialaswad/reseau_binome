package polytech.si3.firstserver.client;

import polytech.si3.User;

/**
 * Created by danialaswad on 03/05/2016.
 */
public class ClientMain {
    public static void main(String args[]){
        User user = new User(1,"danial","aswad","danialaswad@outlook.com","007");
        RequestBuilder builder = new RequestBuilder(user);
        builder.build();// This is where the client should choose or create their request
        Thread client = new IdeaClient("localhost", 9000, builder.getRequest());
        client.start();
    }
}
