package pl.homebudgetapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.homebudgetapp.Entity.Bill;

import java.util.List;


public interface BillRepository extends JpaRepository<Bill, Long> {

	List<Bill> findAllByDate(String date);

}
