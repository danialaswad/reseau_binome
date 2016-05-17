package polytech.si3.firstserver.client;

import polytech.si3.firstserver.client.builder.json.JSONConnexion;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by danialaswad on 03/05/2016.
 */
public class JSONClient extends Thread {

    private Socket clientSocket;
    private int port;
    private String host;
    private JSONConnexion connexion;

    public JSONClient(String host, int port, JSONConnexion connexion){
        this.host = host;
        this.port = port;
        this.connexion = connexion;
    }

    public void run(){
        try {
            int i = 1;
            while (i != 0){
                connexion.prompter();
                System.out.println(connexion.getRequest());
               // System.out.println("LINE : " + in.readLine());
            }
            System.out.println("TEST");
            clientSocket = new Socket(host,port);
            System.out.println("TEST");
           BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            System.out.println(connexion.getRequest());
            out.writeUTF(connexion.getRequest());
            System.out.println("TEST");
            System.out.println("LINE : " + in.readLine());
            


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}