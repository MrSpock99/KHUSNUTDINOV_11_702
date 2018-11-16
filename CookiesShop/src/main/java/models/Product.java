package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class Product implements Serializable {
    private Long id;
    private String name;
    private Integer cost;
    private static final long serialVersionUID = 1113799434508676095L;
}
