package iit.api.Personal.Finance.Tracker.controller;

import iit.api.Personal.Finance.Tracker.entity.Transaction;
import iit.api.Personal.Finance.Tracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/v1")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Transaction> transactions = transactionService.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "dashboard";
    }

    @GetMapping("/transaction-entry")
    public String transactionEntryForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "transaction-entry";
    }

    @PostMapping("/add-transaction")
    public String addTransaction(Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return "redirect:/dashboard";
    }

    @GetMapping("/name")
    public String getName() {
        return "TransactionController";
    }
}

