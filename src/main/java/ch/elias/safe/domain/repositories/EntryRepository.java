package ch.elias.safe.domain.repositories;

import ch.elias.safe.domain.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Integer> {

    List<Entry> findAllByActiveOrderByIdDesc(boolean active);

    Optional<Entry> findByIdAndActive(Integer id, boolean active);

}
