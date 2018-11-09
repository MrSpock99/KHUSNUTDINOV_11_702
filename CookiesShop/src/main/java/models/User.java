package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
public class User implements Serializable {
    private Long id;
    private String email;
    private String hashPassword;
    private static final long serialVersionUID = 1113799434508676095L;

}
