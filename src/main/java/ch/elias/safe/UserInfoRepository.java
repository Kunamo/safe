package ch.elias.safe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    List<UserInfo> findAllByActiveOrderByIdDesc(boolean active);
    Optional<UserInfo> findByIdAndActive(Integer id, boolean active);

}
