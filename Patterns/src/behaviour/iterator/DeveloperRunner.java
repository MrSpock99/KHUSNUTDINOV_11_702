package behaviour.iterator;

public class DeveloperRunner {
    public static void main(String[] args) {
        String[] skills = {"Весна", "Ява"};
        JavaDeveloper developer = new JavaDeveloper("Ayaz",skills);
        Iterator iterator = developer.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}
