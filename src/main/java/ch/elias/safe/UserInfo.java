package ch.elias.safe;

import javax.management.relation.Role;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    private Role role;
    private boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    //set firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Get firstName
    public String getFirstName() {
        return firstName;
    }

    //Set Lastname
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Get Lastname
    public String getLastName() {
        return lastName;
    }

    //Set Role
    public void setRole(Role role) {
        this.role = role;
    }

    //Get Role
    public Role getRole() {
        return role;
    }

    //Set Active
    public void setActive(boolean active) {
        this.active = active;
    }

    //Get Active
    public boolean isActive() {
        return active;
    }

    //Set CreatedAt
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    //Get CreatedAt
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    //Set UpdatedAt
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    //Get UpdatedAt
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    //Set Id
    public void setId(Integer id) {
        this.id = id;
    }

    //Get Id
    public Integer getId() {
        return id;
    }
}
