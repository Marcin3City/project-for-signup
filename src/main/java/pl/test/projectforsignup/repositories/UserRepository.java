package pl.test.projectforsignup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.test.projectforsignup.models.UserClass;

@Repository
public interface UserRepository extends JpaRepository<UserClass, Long> {
}
