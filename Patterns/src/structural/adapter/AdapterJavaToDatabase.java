package structural.adapter;

public class AdapterJavaToDatabase extends JavaApplication implements Database {

    @Override
    public void insert() {
        saveObj();
    }

    @Override
    public void delete() {
        deleteObj();
    }

    @Override
    public void update() {
        updateObj();
    }

    @Override
    public void read() {
        readObj();
    }
}
