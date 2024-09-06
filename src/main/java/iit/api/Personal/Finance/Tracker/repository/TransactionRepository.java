package iit.api.Personal.Finance.Tracker.repository;



import iit.api.Personal.Finance.Tracker.entity.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(Long id);
}


