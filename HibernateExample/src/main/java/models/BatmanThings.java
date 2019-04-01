package models;

import javax.persistence.*;

@MappedSuperclass
public class BatmanThings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String name;
    private int amount;
    @Column(name = "image_base_64", length = 300000)
    private String imageBase64;

    public BatmanThings() {

    }
}


