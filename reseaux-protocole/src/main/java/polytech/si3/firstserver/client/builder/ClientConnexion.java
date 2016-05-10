package polytech.si3.firstserver.client.builder;

import polytech.si3.User;
import polytech.si3.firstserver.client.handler.Handler;
import polytech.si3.requests.Request;

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
    private static final int PROF = 1;
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

    public void prompter(){

        System.out.print(PROMPT+" ");
        String args = scanner.nextLine();

        while(args.equals("help") || args.equals("")) {
            reflect.printMethod();
            System.out.print(PROMPT+" ");
            args = scanner.nextLine();
        }

        String[] params = args.split(" ");

        List<String> paramlist = new ArrayList<>(Arrays.asList(params));
        String method = paramlist.remove(0);

        params = new String[paramlist.size()];
        paramlist.toArray(params);

        try {
            reflect.createRequest(method,params);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException |IllegalArgumentException e) {}
    }

    public Request getBuilder(){
        return builder.getRequest();
    }

    public void read(Object object){handler.readReply(object);}

    public User getUser(){
        return user;
    }
}
