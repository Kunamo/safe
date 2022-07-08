package ch.elias.safe.domain.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class MasterUser {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String userName;
private String password;
private boolean active = true;
}
