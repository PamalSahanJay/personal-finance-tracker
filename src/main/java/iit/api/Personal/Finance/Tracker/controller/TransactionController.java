package iit.api.Personal.Finance.Tracker.controller;

import iit.api.Personal.Finance.Tracker.entity.Transaction;
import iit.api.Personal.Finance.Tracker.service.TransactionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/trans")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam("email") String email, Model model) {
        if (email == null || email.isEmpty()) {
            return "redirect:/auth/login";
        }
        model.addAttribute("email", email);
        return "finance-dashboard";
    }

//    @GetMapping("/dashboard")
//    public String dashboard(Model model) {
//        List<Transaction> transactions = transactionService.getAllTransactions();
//        model.addAttribute("transactions", transactions);
//        return "dashboard";
//    }

    @RequestMapping("/transaction-entry")
    public String transactionEntryForm(Model model) {
//        model.addAttribute("transaction", new Transaction());
        return "finance-transaction-entry";
    }

    @PostMapping("/add-transaction")
    public String addTransaction(Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return "redirect:/dashboard";
    }

}

