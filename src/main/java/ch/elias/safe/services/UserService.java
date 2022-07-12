package ch.elias.safe.services;
import ch.elias.safe.domain.entities.User;
import ch.elias.safe.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   // @PostConstruct
   // private void init() {
       // User user1 = new User();
       // user1.setId(1);
       // user1.setActive(true);
       // user1.setUsername("Elias");
       // user1.setPassword("password");
//
       // User user2 = new User();
       // //user2.setActive(true);
       // user2.setId(2);
       // user2.setUsername("Jessica");
        //user2.setPassword("Password-jess");
//
        ////Inactive User for Test Purposes
        //User user3 = new User();
        ////user3.setActive(false);
        //user3.setId(3);
        //user3.setUsername("Jeff");
        //user3.setPassword("deleted-pw");
//
       // createMasterUser(user1);
        //createMasterUser(user2);
        //createMasterUser(user3);
//    }

    public User createMasterUser(User user) {
        return userRepository.save(user);
    }
}
