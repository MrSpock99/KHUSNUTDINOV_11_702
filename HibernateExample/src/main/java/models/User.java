package models;

import javax.persistence.*;

@Entity(name = "db_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String name;
    @Column(length = 40)
    private String email;
    @Column(name = "hash_password", length = 200)
    private String hashPassword;
}
