import java.io.*;
import java.lang.reflect.*;
import java.util.*;




public class Lecture5Reflect {

    public static void checkConsts(Object obj)  {
        if(obj == null)
            return;
        Class<?> clazz = obj.getClass();
        do {
            try {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.getType().equals(String.class) &&
                            Modifier.isFinal(field.getModifiers())&& Modifier.isStatic(field.getModifiers())) {
                        if (field.get(obj) == field.getName())
                            System.out.println(field.get(obj) + " ==  " + field.getName());
                        else
                            System.out.println(field.get(obj) + " != " + field.getName());
                    }
                }
            } catch (IllegalAccessException exc) {
                System.out.println(exc.getMessage());
            }
            clazz = clazz.getSuperclass();
        } while (clazz != null);
    }

    public static boolean isGetter(Method method){
        if (!method.getName().startsWith("get")) {
            return false;
        }
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        if (void.class.equals(method.getReturnType())) {
            return false;
        }
        return true;
    }

    public static void printGetters(Class<?> clazz){
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (isGetter(method))
            System.out.println(method.getName()+ "  "+ method.getReturnType());
        }
    }

    public static void printGetters(Object obj){
        if(obj == null)
            return;
        printGetters(obj.getClass());
    }

    public static void printMethods(Class clazz){
        do {
            System.out.println(clazz.getName());
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
            }
            clazz = clazz.getSuperclass();
            System.out.println();
        } while (clazz != null);
    }

    public static void printMethods(Object obj){
        if(obj == null)
            return;
        printMethods(obj.getClass());
    }

    public static void main (String [] args) {
        C c = new C();
        printMethods(C.class);

        System.out.println("GETTERS");
        printGetters(c);
       // checkConsts(c);
        C q = new C("abd", "bfg", "story", "drama" );
        checkConsts(q);
    }
}
