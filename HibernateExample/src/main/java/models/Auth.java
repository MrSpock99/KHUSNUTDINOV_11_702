package models;

import javax.persistence.*;

@Entity(name = "auth")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "cookie_value", length = 60)
    private String cookieValue;
}
