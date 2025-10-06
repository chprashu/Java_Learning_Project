package learn.testRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.testVOs.UserVO;

@Repository
public interface UserRepo extends JpaRepository<UserVO, Integer> {

    Optional<UserVO> findByUsername(String username);

}