package com.example.tryquerydsl.qd;

/*

    스프링부트 2.x는  javax.~~
    ,  3부터는  jakarta. ~~~

    ex) 스프링부트 2.x => //import javax.persistence.Entity;
    ex) 스프링부트 3.0 ~    import jakarta.persistence.Entity;
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String pwd;

}
