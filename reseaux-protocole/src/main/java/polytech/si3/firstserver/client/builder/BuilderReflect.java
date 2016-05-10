package polytech.si3.firstserver.client.builder;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by danialaswad on 09/05/2016.
 */
public class BuilderReflect {

    private Class reflectClass;
    private Builder builder;
    private Map<String,Class[]> methodMap;

    public BuilderReflect(Builder builder){
        this.builder = builder;
        reflectClass = builder.getClass();
        methodMap = new HashMap<>();
        initMap();
    }

    private void initMap() {
        Method[] methods = reflectClass.getDeclaredMethods();
        for (Method method : methods){
            if (!method.getName().startsWith("get") && !method.getName().startsWith("auth")) {
                    methodMap.put(method.getName(),method.getParameterTypes());
            }
        }
    }

    public void printMethod(){
        System.out.println("\n\tRequest " + " --> Description" + " --> Manual");
        for (String m : methodMap.keySet()){
            System.out.print("\t" + m + " --> " + UserRequest.valueOf(m.toUpperCase()).getDescrition() +
                    " --> " + UserRequest.valueOf(m.toUpperCase()).getManual() + "\n");
        }
        System.out.println();
    }

    public void createRequest(String methodName, Object... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException , IllegalArgumentException{
        Method method = reflectClass.getMethod(methodName,methodMap.get(methodName));
        method.invoke(builder,args);
    }
}
