package ch.elias.safe.domain.repositories;

import ch.elias.safe.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    //List<User> findAllByActiveOrderByIdDesc(boolean active);
    //Optional<User> findByIdAndActive(Integer id, boolean active);

}
