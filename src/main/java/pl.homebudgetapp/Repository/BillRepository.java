package pl.homebudgetapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.homebudgetapp.Entity.Bill;


public interface BillRepository extends JpaRepository<Bill, Long> {


}
