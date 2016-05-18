package si3.firstserver.client;

import si3.firstserver.client.builder.ClientConnexion;
import si3.replies.Reply;
import si3.requests.RequestType;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by danialaswad on 03/05/2016.
 */
public class IdeaClient extends Thread {

    private Socket clientSocket;
    private int port;
    private String host;
    private ClientConnexion connexion;

    public IdeaClient(String host,int port, ClientConnexion connexion){
        this.host = host;
        this.port = port;
        this.connexion = connexion;
    }

    public void run(){
        try {
            clientSocket = new Socket(host,port);
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.writeObject(connexion.getBuilder());
            connexion.read(in.readObject());
            while (true){
                connexion.prompter();
                out.writeObject(connexion.getBuilder());
                connexion.read(in.readObject());
            }

        } catch (IOException  e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}