package polytech.si3.firstserver.client;

import polytech.si3.firstserver.client.builder.ClientConnexion;

/**
 * Created by danialaswad on 03/05/2016.
 */
public class ClientMain {
    public static void main(String args[]){
        ClientConnexion connexion = new ClientConnexion();// This is where the client should choose or create their request
        Thread client = new IdeaClient("localhost", 9001, connexion);
        client.start();

    }
}
