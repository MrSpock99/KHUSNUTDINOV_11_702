package creational.prototype;

public class Main {
    public static void main(String[] args) {
        Project project = new Project("a","a.ru","hello world!");
        ProjectFactory factory = new ProjectFactory();
        factory.setProject(project);
        System.out.println(factory.getProject());
        System.out.println("///////////////////");
        System.out.println(factory.getCopy());
    }
}
