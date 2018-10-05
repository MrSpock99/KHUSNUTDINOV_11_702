package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class BatmanThings {
    String name;
    int amount;
    private Long id;

    public BatmanThings() {

    }
}


