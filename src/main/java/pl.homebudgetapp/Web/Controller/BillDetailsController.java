package pl.homebudgetapp.Web.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.homebudgetapp.Entity.Bill;
import pl.homebudgetapp.Entity.BillDetails;
import pl.homebudgetapp.Repository.BillDetailsRepository;
import pl.homebudgetapp.Repository.BillRepository;
import pl.homebudgetapp.Service.BillDetailsService;
import pl.homebudgetapp.Web.Dtos.BillDTO;
import pl.homebudgetapp.Web.Dtos.BillDetailsDTO;
import pl.homebudgetapp.Web.Dtos.UserDTO;
import pl.homebudgetapp.Web.Dtos.UserLoginDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class BillDetailsController {

	@Autowired
	BillRepository billRepository;

	@Autowired
	BillDetailsRepository billDetailsRepository;

	@Autowired
	BillDetailsService  billDetailsService;

	@GetMapping("/edit/{id}")
	public String editUserBill(Model model,
	                           @SessionAttribute(value = LoginController.LOGGED_USER_KEY,
			                           required = false) UserDTO loggedUser, @PathVariable Long id) {
		if (loggedUser == null) {
			return "redirect:/login";
		}
		Bill bill = billRepository.findOne(id);
		BillDTO billDTO = new BillDTO();
		billDTO.setId(bill.getId());
		billDTO.setTotal(bill.getTotal());
		billDTO.setUserId(bill.getUser().getId());
		List<BillDetailsDTO> billDetailsDTOS = new ArrayList<>();
		for (BillDetails details : bill.getBillDetails()) {
			BillDetailsDTO billDetailsDTO = new BillDetailsDTO();
			billDetailsDTO.setId(details.getId());
			billDetailsDTO.setCategory(details.getCategory());
			billDetailsDTO.setAmount(details.getAmount());
			billDetailsDTO.setDescription(bill.getDescription());
			billDetailsDTO.setDate(bill.getDate());
			billDetailsDTOS.add(billDetailsDTO);
		}
		billDTO.setDetailsDTOS(billDetailsDTOS);

		if (!loggedUser.getId().equals(bill.getUser().getId())) {
			return "/main";
		}
		model.addAttribute("editBill", billDTO);
		model.addAttribute("billDetails", new BillDetailsDTO());
		model.addAttribute("loggedUser", loggedUser);

		return "edit";
	}

	@PostMapping("/edit/{billId}")
	public String saveDetails(@ModelAttribute("billDetails") BillDetailsDTO billDetailsDTO,
	                          BindingResult bindingResult, HttpSession session, @PathVariable Long billId) {
		System.out.println(billDetailsDTO);
		billDetailsService.update(billDetailsDTO,billId);
		return "redirect:/edit/" + billId;
	}


	@ModelAttribute("categories")
	public List<String> categories() {
		String[] cat = {"jedzenie", "transport", "rtv/agd", "kosmetyki", "środki czystości", "ubrania"};
		return Arrays.asList(cat);
	}

}
