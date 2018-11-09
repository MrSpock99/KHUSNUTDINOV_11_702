package patterns.composite;

public class Button implements Window {
    @Override
    public void draw() {
        System.out.println("I am button");
    }
}
