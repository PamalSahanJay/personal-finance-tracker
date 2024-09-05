package iit.api.Personal.Finance.Tracker.controller;

import iit.api.Personal.Finance.Tracker.entity.Category;
import iit.api.Personal.Finance.Tracker.entity.Transaction;
import iit.api.Personal.Finance.Tracker.service.CategoryService;
import iit.api.Personal.Finance.Tracker.service.TransactionService;
import iit.api.Personal.Finance.Tracker.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/trans")
public class TransactionController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/transaction-entry")
    public String transactionEntryForm(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");
        model.addAttribute("email", email);
        return "finance-transaction-entry";
    }

    @RequestMapping("/category-entry")
    public String categoryEntryForm( Model model) {
        return "finance-category-entry";
    }

    @PostMapping("/add-transaction")
    public String addTransaction(Model model, HttpServletRequest request, HttpSession session) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/auth/login?sessionExpiration";
        }
        String amountStr = request.getParameter("amount");
        String category = request.getParameter("category");
        String description = request.getParameter("description");
        String dateStr = request.getParameter("date");
        String type = request.getParameter("type");

        BigDecimal amount = new BigDecimal(amountStr);

        Date transactionDate=null;
        try {
            transactionDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transaction.setTransactionDate(transactionDate);
        transaction.setType(type);
        transaction.setUser(userService.findByEmail(email));
        transaction.setCategory(categoryService.findByName(category));

        try {
            transactionService.saveTransaction(transaction);
            return "redirect:/dashboard?successTransaction";
        } catch (Exception e) {
            return "redirect:/dashboard?errorTransaction";
        }

    }



}

