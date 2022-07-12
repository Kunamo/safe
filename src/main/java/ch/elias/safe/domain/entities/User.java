package ch.elias.safe.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;

    //Have to check how to implement private boolean active = true;

    @Transient
    private String passwordConfirm;

}
