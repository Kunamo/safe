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
    private final RSAService rsaService;

    public EntryService(EntryRepository entryRepository, RSAService rsaService) {
        this.entryRepository = entryRepository;
        this.rsaService = new RSAService();
    }

    public Entry getEntry(Integer id) {
        return entryRepository.findByIdAndActive(id,true).orElseThrow(NotFoundException::new);
    }

    public Entry createEntry(Entry entry) {
        return entryRepository.save(entry);
    }

    public List<Entry> getAllEntries() {
        // Executes SQL Statement first, THEN modifies to decrypt the data.
        for (Entry entry : entryRepository.findAllByActiveOrderByIdDesc(true)) {
            entry.setPassword(rsaService.decrypt(entry.getPassword()));
        }
        // Sends modified (decrypted) data to EntryController.
        return entryRepository.findAllByActiveOrderByIdDesc(true);
    }

    public Entry updateEntry(Integer id, Entry request) {
        Entry fromDb = getEntry(id);
        fromDb.setWebsite(request.getWebsite());
        fromDb.setUsername(request.getUsername());
        fromDb.setNotes(request.getNotes());
        fromDb.setPassword(rsaService.encrypt(request.getPassword()));
        fromDb.setActive(request.isActive());
        fromDb.setUpdatedAt(LocalDateTime.now());
        return entryRepository.save(fromDb);
    }
}
