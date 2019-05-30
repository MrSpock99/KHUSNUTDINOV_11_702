package structural.adapter;

public class DatabaseRunner {
    public static void main(String[] args) {
        Database database = new AdapterJavaToDatabase();
        database.delete();
        database.insert();
        database.read();
        database.update();
    }
}
