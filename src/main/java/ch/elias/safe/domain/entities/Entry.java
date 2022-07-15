package ch.elias.safe.domain.entities;

import ch.elias.safe.services.RSAService;
import lombok.Data;
import org.hibernate.boot.model.relational.Sequence;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String website;
    private String username; // NEW
    private String notes; // NEW
    // Needed to store encoded password in DB, (very long due to encryption)
    @Column(length=1000)
    private String password;
    private boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
