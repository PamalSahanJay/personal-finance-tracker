package iit.api.Personal.Finance.Tracker.service;

import iit.api.Personal.Finance.Tracker.entity.Category;
import iit.api.Personal.Finance.Tracker.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public void saveCategory(Category category) throws Exception {
        categoryRepository.save(category);
    }

    public List<Category> findByType(String type) {
        return categoryRepository.findByType(type);
    }

    public Category findByName(String category) {
        return categoryRepository.findByName(category);
    }
}
