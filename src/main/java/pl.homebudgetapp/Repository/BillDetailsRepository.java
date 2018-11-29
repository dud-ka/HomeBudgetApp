package pl.homebudgetapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.homebudgetapp.Entity.BillDetails;

import java.util.List;

public interface BillDetailsRepository extends JpaRepository<BillDetails, Long> {

	@Query(value = "SELECT * FROM bill_details inner JOIN (SELECT bill.description, bill.date, bill.user_id, bill.id FROM bill WHERE bill.user_id = ?1) as tab ON tab.id = bill_details.bill_id",  nativeQuery = true)
	List<BillDetails> findAllUserBills(Long userid);
	@Query(value = "SELECT * FROM bill_details inner JOIN (SELECT bill.description, bill.date, bill.user_id, bill.id FROM bill WHERE bill.id = ?1) as tab ON tab.id = bill_details.bill_id",  nativeQuery = true)
	List<BillDetails> findUserBill(Long billid);


}
