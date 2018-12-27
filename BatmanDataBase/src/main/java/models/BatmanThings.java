package models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class BatmanThings {
    private String name;
    private int amount;
    private Long id;
    private String imageBase64;

    public BatmanThings() {

    }
}


