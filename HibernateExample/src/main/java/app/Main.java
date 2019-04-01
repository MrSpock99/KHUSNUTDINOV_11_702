package app;

import models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hibernate_test");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "Metallica1981");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Auth.class);
        configuration.addAnnotatedClass(Ammo.class);
        configuration.addAnnotatedClass(Weapon.class);
        configuration.addAnnotatedClass(Transport.class);
        configuration.addAnnotatedClass(Equipment.class);
        configuration.addAnnotatedClass(Subject.class);
        configuration.setProperty("hibernate.show_sql", "true");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.close();
    }
}
