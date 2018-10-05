package ru.itis;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.io.*;
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
import java.util.Scanner;

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

    @Parameter(names = "-db")
    private String db;

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
            Files.list(Paths.get(classFolder)).forEach(file -> {
                        try {
                            URL url = new URL(new File(classFolder).toURI().toString());
                            URLClassLoader loader = URLClassLoader.newInstance(new URL[]{url}, getClass().getClassLoader());
                            classes.add(loader.loadClass(file.getFileName().toString().split("\\.")[0]));
                        } catch (Exception e) {
                            throw new IllegalArgumentException(e);
                        }
                    });

            Field[] fields;
            Constructor[] constructors;
            Method[] methods;

            Class dictClass = null;
            Class[] dictFieldTypes = null;

            for (Class c : classes){
                fields = c.getDeclaredFields();
                constructors = c.getDeclaredConstructors();
                methods = c.getDeclaredMethods();

                System.out.println("class " + c.getName());

                if (c.getName().equals("User")){
                    dictClass = c;
                    dictFieldTypes = new Class[fields.length];

                    for (int i = 0; i < fields.length; i++){
                        dictFieldTypes[i] = fields[i].getType();
                    }
                }

                System.out.println(" -- Fields");
                for (Field field : fields){
                    System.out.println(field.toString());
                }

                System.out.println();

                System.out.println(" -- Constructors");
                for (Constructor constructor : constructors){
                    System.out.println(constructor.toString());
                }

                System.out.println();

                System.out.println(" -- Methods");
                for (Method method : methods){
                    System.out.println(method.toString());
                }

                System.out.println("---------------------------------------------------------");

            }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.println();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.println();

        System.out.print("Is human?: ");
        boolean isHuman = scanner.nextBoolean();
        System.out.println();

        Constructor constructor = dictClass.getDeclaredConstructor(dictFieldTypes);

        serialize(constructor.newInstance(name,age,isHuman));





    }

    private static void serialize(Object o){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("User.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(o);
            oos.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        System.out.println("Before serialization");
        System.out.println(o.toString());
        System.out.println();

        try {
            FileInputStream file = new FileInputStream("User.txt");
            ObjectInputStream ois = new ObjectInputStream(file);
            Object o1 = ois.readObject();
            System.out.println("After serialization");
            System.out.println(o1.toString());
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }


}
