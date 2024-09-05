package iit.api.Personal.Finance.Tracker.controller;

import iit.api.Personal.Finance.Tracker.entity.Category;
import iit.api.Personal.Finance.Tracker.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public List<Category> getCategories(@RequestParam String type) {
        return categoryService.findByType(type);
    }
}
