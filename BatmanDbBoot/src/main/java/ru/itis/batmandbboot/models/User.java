package ru.itis.batmandbboot.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "db_user")
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
