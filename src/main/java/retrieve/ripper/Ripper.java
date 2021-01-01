package retrieve.ripper;

import retrieve.rabbit.RabbitAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.*;

public class Ripper {

    public static void runnerRipperGetClass(Object object) {
        Class clazz = object.getClass();
        System.out.println(clazz.getName());
    }

    public static void runnerRipperMethods(Object object) {
        Class clazz = object.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    public static void runnerRipperFields(Object object) {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    public static void runnerRipperAnnotationsFields(Object object) {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(field.getName() + "  " + annotation.toString());
            }
        }
    }

    public static void fillPrivateFields(Object object) throws IllegalAccessException {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation annotation = field.getAnnotation(RabbitAnnotation.class);
            if (annotation == null) {
                continue;
            } else {
                field.setAccessible(true);
                field.set(object, "the establishment of a new value");
                field.setAccessible(false);
            }
        }
    }

    public static Object createNewInstanceClassThrowReflection(Object object) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = object.getClass();
        return clazz.getConstructor().newInstance();
    }
}
