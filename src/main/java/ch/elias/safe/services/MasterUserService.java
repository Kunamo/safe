package ch.elias.safe.services;
import ch.elias.safe.domain.entities.MasterUser;
import ch.elias.safe.domain.repositories.MasterUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MasterUserService {
    private final MasterUserRepository masterUserRepository;

    public MasterUserService(MasterUserRepository masterUserRepository) {
        this.masterUserRepository = masterUserRepository;
    }

    @PostConstruct
    private void init() {
        MasterUser masterUser1 = new MasterUser();
        masterUser1.setId(1);
        masterUser1.setActive(true);
        masterUser1.setUserName("Elias");
        masterUser1.setPassword("password");

        MasterUser masterUser2 = new MasterUser();
        masterUser2.setActive(true);
        masterUser2.setId(2);
        masterUser2.setUserName("Jessica");
        masterUser2.setPassword("Password-jess");

        //Inactive User for Test Purposes
        MasterUser masterUser3 = new MasterUser();
        masterUser3.setActive(false);
        masterUser3.setId(3);
        masterUser3.setUserName("Jeff");
        masterUser3.setPassword("deleted-pw");

        createMasterUser(masterUser1);
        createMasterUser(masterUser2);
        createMasterUser(masterUser3);
    }

    public MasterUser createMasterUser(MasterUser masterUser) {
        return masterUserRepository.save(masterUser);
    }
}
