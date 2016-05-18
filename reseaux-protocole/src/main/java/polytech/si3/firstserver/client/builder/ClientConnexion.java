package si3.firstserver.client.builder;

import si3.User;
import si3.firstserver.client.handler.Handler;
import si3.requests.Request;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by danialaswad on 09/05/2016.
 */
public class ClientConnexion {

    private static final int STUDENT = 1;
    private static final int PROF = 0;
    private User user;
    private Builder builder;
    private BuilderReflect reflect;
    private Handler handler;
    private final static String PROMPT = ">>>>>>>>";
    private Scanner scanner;


    public ClientConnexion(){
        scanner = new Scanner(System.in);
        createUser();
        builder = new Builder(user);
        handler= new Handler();
        reflect = new BuilderReflect(builder);
        builder.authentification();
    }

    private void createUser() {
        System.out.print(PROMPT+" name : ");
        String name = scanner.nextLine();
        System.out.print(PROMPT+" surname : ");
        String surname = scanner.nextLine();
        System.out.print(PROMPT+" email : ");
        String email = scanner.nextLine();
        System.out.print(PROMPT+" id : ");
        String id = scanner.next();
        user = new User(STUDENT, name, surname, email, id);
    }

    /**
     * The prompter on the command line
     * Retrieve the input on the command line and calls the
     * reflect.createRequest to generate replies
     */
    public void prompter(){

        System.out.print(PROMPT+" ");
        String args = scanner.nextLine();

        while(args.equals("help") || args.equals("")) {
            reflect.printMethod();
            System.out.print(PROMPT+" ");
            args = scanner.nextLine();
        }

        String[] params = args.split(" ");

        List<String> paramlist = new ArrayList<String>(Arrays.asList(params));
        String method = paramlist.remove(0);

        params = new String[paramlist.size()];
        paramlist.toArray(params);

       // try {
        try {
            reflect.createRequest(method,params);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException |IllegalArgumentException e) {}
    }

    /**
     * Getter for builder instance
     * @return
     */
    public Request getBuilder(){
        return builder.getRequest();
    }

    /**
     * Forwards the object to the handler object to read response and generate reply
     * @param object
     */
    public void read(Object object){handler.readReply(object);}

    /**
     * Getter for the user instance
     * @return
     */
    public User getUser(){
        return user;
    }
}
