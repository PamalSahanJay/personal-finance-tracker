package iit.api.Personal.Finance.Tracker.repository;



import iit.api.Personal.Finance.Tracker.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}


