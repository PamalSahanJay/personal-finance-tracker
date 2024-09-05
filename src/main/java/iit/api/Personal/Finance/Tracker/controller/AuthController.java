package iit.api.Personal.Finance.Tracker.controller;

import iit.api.Personal.Finance.Tracker.dto.LoginDTO;
import iit.api.Personal.Finance.Tracker.entity.User;
import iit.api.Personal.Finance.Tracker.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.FacesRequestAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        return "login";
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request, Model model) {
        return "register";
    }

    @PostMapping("createUser")
    public String createUser(@ModelAttribute User user) {
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            return "redirect:/auth/register?error";
        }
        return "redirect:/auth/login?success";
    }

    @PostMapping("userLogin")
    public String userLogin(@ModelAttribute LoginDTO loginDTO, HttpSession session) {
        boolean checkStatus = userService.checkUser(loginDTO);
        if (checkStatus) {
            session.setAttribute("email", loginDTO.getEmail());
            return "redirect:/dashboard";
        }
        else {
            return "redirect:/auth/login?error";
        }
    }

}
