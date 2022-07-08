package ch.elias.safe.services;

import ch.elias.safe.domain.entities.Entry;
import ch.elias.safe.domain.repositories.EntryRepository;
import ch.elias.safe.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EntryService {

    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @PostConstruct
    private void init() {
        Entry entry1 = new Entry();
        entry1.setId(1);
        entry1.setPassword("Elias");
        entry1.setWebsite("asdf");
        Entry entry2 = new Entry();
        entry2.setId(2);
        entry2.setPassword("blubebr");
        entry2.setWebsite("asdf");
        createEntry(entry1);
        createEntry(entry2);
    }

    public Entry getEntry(Integer id) {
        return entryRepository.findByIdAndActive(id,true).orElseThrow(NotFoundException::new);
    }

    public Entry createEntry(Entry entry) {
        return entryRepository.save(entry);
    }

    public List<Entry> getAllEntries() {
        return entryRepository.findAllByActiveOrderByIdDesc(true);
    }

    public Entry updateEntry(Integer id, Entry request) {
        Entry fromDb = getEntry(id);
        fromDb.setPassword(request.getPassword());
        fromDb.setWebsite(request.getWebsite());
        fromDb.setActive(request.isActive());
        fromDb.setUpdatedAt(LocalDateTime.now());
        return entryRepository.save(fromDb);
    }
}
