package polytech.si3.firstserver.client.builder.json;


import polytech.si3.firstserver.client.builder.Builder;
import polytech.si3.firstserver.client.builder.UserRequest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by danialaswad on 09/05/2016.
 */
public class JSONBuilderReflect {


    protected Class reflectClass;
    protected JSONBuilder builder;
    protected Map<String,Class[]> methodMap;

    public JSONBuilderReflect(JSONBuilder builder){
        this.builder = builder;
        reflectClass = builder.getClass();
        methodMap = new HashMap<>();
        initMap();
    }

    private void initMap() {
        Method[] methods = reflectClass.getDeclaredMethods();
        for (Method method : methods){
            if (!method.getName().startsWith("get") || !method.getName().startsWith("auth")) {
                methodMap.put(method.getName(),method.getParameterTypes());
                System.out.println(method.getName() );
            }
        }
    }

    public void printMethod(){
        System.out.println("\n\tRequest " + " --> Description" + " --> Manual");
        for (String m : methodMap.keySet()){
            System.out.print("\t" + m + " --> "+ JSONEnum.valueOf(m.toUpperCase()).getDescrition() +
                    " --> " + JSONEnum.valueOf(m.toUpperCase()).getManual()+ "\n");
        }
        System.out.println();
    }

    public void createRequest(String methodName, Object... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException , IllegalArgumentException{
        Method method = reflectClass.getMethod(methodName,methodMap.get(methodName));

        System.out.println(method.getName());
        method.invoke(builder,args);
        System.out.println( builder.getRequest());
    }
}
