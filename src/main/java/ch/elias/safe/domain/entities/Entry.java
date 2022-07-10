package ch.elias.safe.domain.entities;

import ch.elias.safe.services.RSAService;
import lombok.Data;
import org.hibernate.boot.model.relational.Sequence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String website;
    // Needed to store long encoded string in database
    @Column(length=1000)
    private String password;
    private boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

}
