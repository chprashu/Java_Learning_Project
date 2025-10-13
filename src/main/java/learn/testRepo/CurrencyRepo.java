package learn.testRepo;

import learn.testVOs.CurrencyVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends JpaRepository<CurrencyVO, Integer> {
}
