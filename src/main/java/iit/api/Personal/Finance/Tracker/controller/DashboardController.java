package iit.api.Personal.Finance.Tracker.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("email")
public class DashboardController {
    @GetMapping("/dashboard")
    public String getDashboard(HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        model.addAttribute("email", email);
        return "finance-dashboard";
    }
}
