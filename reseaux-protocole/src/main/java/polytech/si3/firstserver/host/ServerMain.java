package polytech.si3.firstserver.host;

import java.io.IOException;

/**
 * Created by danialaswad on 03/05/2016.
 */
public class ServerMain {
    public static void main(String [] args)
    {
        int port = 9000;
        try
        {
            Thread t = new IdeaServer(port);
            t.start();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
