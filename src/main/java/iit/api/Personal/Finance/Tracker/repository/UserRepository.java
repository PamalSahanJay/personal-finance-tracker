package iit.api.Personal.Finance.Tracker.repository;


import iit.api.Personal.Finance.Tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

