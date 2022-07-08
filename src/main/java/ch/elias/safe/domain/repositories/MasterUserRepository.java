package ch.elias.safe.domain.repositories;

import ch.elias.safe.domain.entities.MasterUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MasterUserRepository extends JpaRepository<MasterUser, Integer> {
    List<MasterUser> findAllByActiveOrderByIdDesc(boolean active);

    Optional<MasterUser> findByIdAndActive(Integer id, boolean active);

}
