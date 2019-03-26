package ru.itis.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private Long id;
    private String name;
    private String email;
    private String hashPassword;
}
