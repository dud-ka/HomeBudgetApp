package pl.homebudgetapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.homebudgetapp.Entity.Bill;
import pl.homebudgetapp.Entity.BillDetails;
import pl.homebudgetapp.Entity.User;
import pl.homebudgetapp.Repository.BillDetailsRepository;
import pl.homebudgetapp.Repository.BillRepository;
import pl.homebudgetapp.Web.Dtos.BillDetailsDTO;
import pl.homebudgetapp.Web.Dtos.UserDTO;
import pl.homebudgetapp.Web.Dtos.UserRegisterDTO;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BillDetailsService {

	@Autowired
	BillDetailsRepository billDetailsRepository;

	@Autowired
	BillRepository billRepository;

	public List<BillDetailsDTO> billList(UserDTO userDTO) {
		List<BillDetailsDTO> billList = new ArrayList<>();
		List<BillDetails> billDetails = billDetailsRepository.findAllUserBills(userDTO.getId());
		for(BillDetails b : billDetails){
			BillDetailsDTO billDetailsDTO = new BillDetailsDTO();
			billDetailsDTO.setId(b.getBill().getId());
			billDetailsDTO.setDate(b.getBill().getDate());
			billDetailsDTO.setDescription(b.getBill().getDescription());
			billDetailsDTO.setAmount(b.getAmount());
			billDetailsDTO.setCategory(b.getCategory());
			billList.add(billDetailsDTO);
		}

		return billList;
	}
	public void update(BillDetailsDTO billDetailsDTO, Long billId){
		Bill bill =	billRepository.findOne(billId);

		BillDetails billDetails = new BillDetails();
		billDetails.setCategory(billDetailsDTO.getCategory());
		billDetails.setAmount(billDetailsDTO.getAmount());
		billDetails.setBill(bill);
		billDetails.setId(billDetailsDTO.getId());

		billDetailsRepository.save(billDetails);

	}


}
