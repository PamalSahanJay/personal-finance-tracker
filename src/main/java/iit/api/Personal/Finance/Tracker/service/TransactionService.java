package iit.api.Personal.Finance.Tracker.service;



import iit.api.Personal.Finance.Tracker.entity.Transaction;
import iit.api.Personal.Finance.Tracker.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public List<Transaction> findByEmail(Long id) {
        return transactionRepository.findByUserId(id);
    }
}

