package patterns.observer;

public class Blogger implements Observer {
    @Override
    public void handle(String trend) {
        System.out.println(trend + " is new trend!");
    }
}
