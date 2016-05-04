package polytech.si3.firstserver.host;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by danialaswad on 03/05/2016.
 */
public class IdeaServer extends Thread{

    private ServerSocket serverSocket;
    private RequestHandler requestHandler;


    public IdeaServer(int port) throws IOException
    {
        try {
            serverSocket = new ServerSocket(port);
        }
        catch (IOException e){System.err.println(e);}
    }

    public void run(){
        while(true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("connected with " + clientSocket.getInetAddress()
                        + " : " + clientSocket.getLocalPort());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                try {
                    requestHandler = new RequestHandler(in.readObject());
                    requestHandler.readRequest(); // This is where request is handled
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                out.writeObject(requestHandler.response()); // Response to the request
                out.close();
                in.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
