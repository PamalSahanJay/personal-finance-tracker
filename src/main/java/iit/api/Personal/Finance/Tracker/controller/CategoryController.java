package iit.api.Personal.Finance.Tracker.controller;

import iit.api.Personal.Finance.Tracker.dto.CategoryDTO;
import iit.api.Personal.Finance.Tracker.entity.Category;
import iit.api.Personal.Finance.Tracker.entity.Transaction;
import iit.api.Personal.Finance.Tracker.service.CategoryService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @PostMapping("/add-category")
    public String addCategory(@ModelAttribute Category category) {
        try {
            categoryService.saveCategory(category);
        } catch (Exception e) {
            return "redirect:/category/category-entry?error";
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/getByType")
    @ResponseBody
    public List<CategoryDTO> getCategories(@RequestParam String type) {
        List<Category> categories = categoryService.findByType(type);
        return categories.stream()
                .map(category -> new CategoryDTO(category.getId(), category.getName(), category.getType()))
                .collect(Collectors.toList());
    }

    @GetMapping("/showAllCategories")
    public String showAllTransaction(Model model, HttpSession session) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "show-all-categories";
    }

    @PostMapping("/deleteCategory/{id}")
    public String deleteTransaction(@PathVariable Long id, RedirectAttributes redirectAttributes, HttpSession session) {
        categoryService.deleteTransaction(id);
        redirectAttributes.addFlashAttribute("message", "Transaction deleted successfully");
        return "redirect:/category/showAllCategories";
    }
}
