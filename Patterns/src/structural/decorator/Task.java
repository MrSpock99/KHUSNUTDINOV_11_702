package structural.decorator;

public class Task {
    public static void main(String[] args) {
        Developer senior = new SeniorJavaDeveloper(new JavaDeveloper());
        senior.makeJob();
    }
}
