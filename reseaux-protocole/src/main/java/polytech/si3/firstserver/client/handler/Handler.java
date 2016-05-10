package polytech.si3.firstserver.client.handler;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by danialaswad on 09/05/2016.
 */
public class Handler {

    private Class readerReflect;
    private Reader reader;
    private Map<String,Class[]> methodMap;

    public Handler(){
        reader = new Reader();
        readerReflect = reader.getClass();
        methodMap = new HashMap<>();
        init();
    }

    private void init() {
        Method[] methods = readerReflect.getDeclaredMethods();
        for (Method method : methods){
            methodMap.put(method.getName(),method.getParameterTypes());
        }
    }

    public void readReply(Object object){
        Class reply = object.getClass();
        Method method;
        try {
            method = readerReflect.getMethod(reply.getSimpleName().toLowerCase(),methodMap.get(reply.getSimpleName().toLowerCase()));
            method.invoke(reader,object);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException |IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
