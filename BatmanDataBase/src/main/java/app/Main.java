package app;

import lombok.SneakyThrows;
import models.Subject;
import models.SubjectType;
import repositories.SubjectsRepositoryJdbcImpl;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.load(new FileReader("C:\\Users\\khusn\\Desktop\\University\\KHUSNUTDINOV_11_702\\BatmanDataBase\\src\\main\\resources\\ru.itis\\application.properties"));
        Connection connection =
                DriverManager.getConnection(properties.getProperty("db.url"),
                        properties.getProperty("db.user"),
                        properties.getProperty("db.password"));

        SubjectsRepositoryJdbcImpl subjectsRepositoryJdbc = new SubjectsRepositoryJdbcImpl(connection);

        Subject subject = subjectsRepositoryJdbc.findByAlias("Joker");
        System.out.println(subject.toString());

        Subject superMan = Subject.builder()
                .alias("Super Man")
                .realName("Clark Kent")
                .type(SubjectType.HERO)
                .build();

        List<Subject> subjectList = subjectsRepositoryJdbc.findAll();

        subjectList.forEach(System.out::println);
    }
}
