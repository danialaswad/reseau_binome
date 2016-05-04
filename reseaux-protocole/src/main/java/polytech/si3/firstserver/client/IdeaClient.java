package polytech.si3.firstserver.client;

import polytech.si3.replies.Reply;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by danialaswad on 03/05/2016.
 */
public class IdeaClient extends Thread {

    private Socket clientSocket;
    private int port;
    private String host;
    private Object object;
    private ResponseHandler responseHandler;

    public IdeaClient(String host,int port, Object object){
        this.host = host;
        this.port = port;
        this.object = object;
    }

    public void run(){
        try {
            clientSocket = new Socket(host,port);
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.writeObject(object);
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            try {
                responseHandler = new ResponseHandler((Reply) in.readObject());
                responseHandler.read(); // This is where response should be handle
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            clientSocket.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
