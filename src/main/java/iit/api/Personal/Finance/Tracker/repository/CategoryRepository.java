package iit.api.Personal.Finance.Tracker.repository;


import iit.api.Personal.Finance.Tracker.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

