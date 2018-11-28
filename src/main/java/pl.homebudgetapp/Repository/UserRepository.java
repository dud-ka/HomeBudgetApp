package pl.homebudgetapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.homebudgetapp.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findAllByEmail(String email);

}
