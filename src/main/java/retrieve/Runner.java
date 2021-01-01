package retrieve;

import retrieve.rabbit.Rabbit;
import retrieve.ripper.Ripper;

import java.lang.reflect.InvocationTargetException;

public class Runner {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Rabbit rabbit = new Rabbit();
        Ripper ripper = new Ripper();


        System.out.println(rabbit.getWeight() + " " + rabbit.getName());

        //  ripper.runnerRipperAnnotationsFields(rabbit);

        ripper.fillPrivateFields(rabbit);
        System.out.println(rabbit.getWeight() + " " + rabbit.getName());

        Object clone = ripper.createNewInstanceClassThrowReflection(rabbit); //create from reflection
       // System.out.println(clone);
        ripper.runnerRipperGetClass(clone);

        System.out.println(new Rabbit()); //creating throw key word "new"

    }
}
