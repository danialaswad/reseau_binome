package polytech.si3.firstserver.client.builder.json;

import polytech.si3.User;
import polytech.si3.firstserver.client.handler.Handler;
import polytech.si3.firstserver.client.jsonrequests.Person;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by danialaswad on 09/05/2016.
 */
public class JSONConnexion {

    private static final int STUDENT = 1;
    private static final int PROF = 1;
    protected Person person;
    protected JSONBuilder builder;
    protected JSONBuilderReflect reflect;
    protected Handler handler;
    protected final static String PROMPT = ">>>>>>>>";
    protected Scanner scanner;

    public JSONConnexion(){
        scanner = new Scanner(System.in);
        createUser();
        builder = new JSONBuilder(person);
        handler= new Handler();
        reflect = new JSONBuilderReflect(builder);

    }

    protected void createUser(){
        System.out.print(PROMPT+" username : ");
        String name = scanner.nextLine();

        System.out.print(PROMPT+" email : ");
        String email = scanner.nextLine();

        System.out.print(PROMPT+" id : ");
        String id = scanner.next();

        int idInt;
        try{idInt = Integer.parseInt(id);}
        catch(Exception e){idInt = 0;}

        person = new Person(idInt,name,email);
    }

    public String getRequest(){
        String r;
        try{r = builder.getRequest().toString();}
        catch(Exception e){e.printStackTrace(); r = "r";}

        return r;
    }

    public void prompter(){

        System.out.print(PROMPT+" ");
        String args = scanner.nextLine();

        while(args.equals("help") || args.equals("")) {
            (reflect).printMethod();
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


}
