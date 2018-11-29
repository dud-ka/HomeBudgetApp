package pl.homebudgetapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.homebudgetapp.Entity.Bill;
import pl.homebudgetapp.Entity.BillDetails;
import pl.homebudgetapp.Entity.User;
import pl.homebudgetapp.Repository.BillDetailsRepository;
import pl.homebudgetapp.Repository.BillRepository;
import pl.homebudgetapp.Web.Dtos.AddBillDTO;
import pl.homebudgetapp.Web.Dtos.BillDetailsDTO;
import pl.homebudgetapp.Web.Dtos.UserDTO;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class BillService {

	@Autowired
	BillRepository billRepository;

	@Autowired
	BillDetailsRepository billDetailsRepository;

	public boolean isdateValid(AddBillDTO addBillDTO){
		LocalDate date = addBillDTO.getDate();
		boolean result = date.isAfter(LocalDate.now());
		return result;
	}

	public Bill saveBill(AddBillDTO addBillDTO, User user) {
		Bill bill = new Bill();
		bill.setDate(addBillDTO.getDate());
		bill.setTotal(addBillDTO.getTotal());
		bill.setDescription(addBillDTO.getDescription());
		bill.setUser(user);

		billRepository.save(bill);
		return bill;
	}

	public void saveBillDetails(BillDetailsDTO billDetailsDTO, Bill bill,
	                            AddBillDTO addBillDTO){
		BillDetails billDetails = new BillDetails();
		billDetails.setBill(bill);
		billDetails.setAmount(addBillDTO.getTotal());
		billDetails.setCategory("nieprzypisane");

		billDetailsRepository.save(billDetails);
	}

}
