package app;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class MainDNA {
    @SneakyThrows
    public static void main(String[] args) {
        FileReader fr =
                new FileReader("E:\\Downloads\\Genome_2.txt");
        int i = 0;

        ArrayList<Character> dnaStr = new ArrayList<>();

        while ((i = fr.read()) != -1) {
            if ((char) (i) == '\n') {
                continue;
            }
            dnaStr.add((char) (i));
        }

        ArrayList<String> list_k2 = new ArrayList<>();
        ArrayList<String> list_k5 = new ArrayList<>();
        ArrayList<String> list_k9 = new ArrayList<>();

        list_k2 = getList(2, dnaStr);
        list_k5 = getList(5, dnaStr);
        list_k9 = getList(9, dnaStr);

        Connection connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "Metallica1981");
        PreparedStatement statement = connection.prepareStatement("insert into dna_2(k_2,k_5,k_9) values (?,?,?)");

        for (int j = 0; j < list_k2.size(); j++){
            try {
                statement.setString(1,list_k2.get(j));
            }catch (IndexOutOfBoundsException ex){
                statement.setString(1,"");
            }

            try {
                statement.setString(2,list_k5.get(j));
            }catch (IndexOutOfBoundsException ex){
                statement.setString(2,"");
            }

            try {
                statement.setString(3,list_k9.get(j));
            }catch (IndexOutOfBoundsException ex){
                statement.setString(3,"");
            }

            statement.execute();
        }
    }

    @SneakyThrows
    private static ArrayList<String> getList(int k, ArrayList<Character> list) {
        ArrayList<String> k_list = new ArrayList<>();

        int counter = 0;

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i));
            counter++;
            if (counter == k) {
                k_list.add(str.toString());
                str = new StringBuilder();
                counter = 0;
                i -= (k - 1);
            }
        }
        return k_list;
    }
}
