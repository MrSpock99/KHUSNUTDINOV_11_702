import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(new Student("Ayaz",2),new Student("Boris",4),new Student("123",123));
        //list.stream().filter(x -> x > 0).collect(Collectors.toList()).forEach(x -> System.out.println(x));
        list.stream().map(x -> x.getGroup() * 2).collect(Collectors.toList()).forEach(System.out::println);
        Student student = new Student("1",1){
            @Override
            public int getGroup() {
                return super.getGroup() + 1;
            }
        };
        System.out.println(student.getGroup());
        Iterator
        student.toString();

    }
}
