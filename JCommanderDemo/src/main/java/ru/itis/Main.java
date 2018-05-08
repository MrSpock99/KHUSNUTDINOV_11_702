package ru.itis;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 03.05.2018
 * Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {

    @Parameter(names = "-classFolder")
    private String classFolder;

    @Parameter(names = "-className",arity = 3)
    private ArrayList<String> classNames = new ArrayList<>();


    public static void main(String[] args) {
        Main main = new Main();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        try {
            main.run();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void run() throws Exception {
        ArrayList<Class> classes = new ArrayList<>();
        Iterator<String> iterator = classNames.iterator();
            Files
                    .list(Paths.get(classFolder))
                    .forEach(file -> {
                        try {
                            URL url = new URL(new File(classFolder).toURI().toString());
                            URLClassLoader loader = URLClassLoader.newInstance(new URL[]{url}, getClass().getClassLoader());
                            classes.add(loader.loadClass(iterator.next()));
                        } catch (Exception e) {
                            throw new IllegalArgumentException(e);
                        }
                    });

            Field[] fields;
            Constructor[] constructors;
            Method[] methods;

            for (Class c : classes){
                fields = c.getDeclaredFields();
                constructors = c.getDeclaredConstructors();
                methods = c.getDeclaredMethods();

                System.out.println("class " + c.getName());

                System.out.println(" -- Fields");
                for (Field field : fields){
                    System.out.println(field);
                }

                System.out.println();

                System.out.println(" -- Constructors");
                for (Constructor constructor : constructors){
                    System.out.println(constructor);
                }

                System.out.println();

                System.out.println(" -- Methods");
                for (Method method : methods){
                    System.out.println(method);
                }

                System.out.println("---------------------------------------------------------");

            }
    }
}
