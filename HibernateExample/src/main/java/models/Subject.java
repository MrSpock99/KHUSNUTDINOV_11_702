package models;

import javax.persistence.*;

@Entity(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Вымышленное имя
    @Column(length = 20)
    private String alias;
    //Реальное имя
    @Column(name = "real_name", length = 40)
    private String realName;
    //Какое оружие против него использовать
    @ManyToOne
    @JoinColumn(name = "weakness_id")
    private Weapon weakness;
    //Какую костюм надеть при битве с ним
    @ManyToOne
    @JoinColumn(name = "defence_id")
    private Equipment defence;
    //Злодей или герой
    @Column(length = 8)
    @Enumerated(value = EnumType.STRING)
    private SubjectType type;
    //Изображение
    @Column(name = "image_base_64", length = 300000)
    private String imageBase64;
}

