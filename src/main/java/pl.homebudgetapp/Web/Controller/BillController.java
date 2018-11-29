package pl.homebudgetapp.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.homebudgetapp.Entity.Bill;
import pl.homebudgetapp.Entity.BillDetails;
import pl.homebudgetapp.Entity.User;
import pl.homebudgetapp.Repository.BillRepository;
import pl.homebudgetapp.Repository.UserRepository;
import pl.homebudgetapp.Service.BillService;
import pl.homebudgetapp.Web.Dtos.AddBillDTO;
import pl.homebudgetapp.Web.Dtos.BillDetailsDTO;
import pl.homebudgetapp.Web.Dtos.UserDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;

@Controller
public class BillController {

	@Autowired
	BillService billService;

	@Autowired
	UserRepository userRepository;
	@Autowired
	BillRepository billRepository;

	@GetMapping("/add")
	public String addBill(Model model,
	                      @SessionAttribute(value = LoginController.LOGGED_USER_KEY,
			                      required = false) UserDTO loggedUser) {
		if(loggedUser==null){
			return "redirect:/login";
		}
		model.addAttribute("loggedUser", loggedUser);
		model.addAttribute("newBill", new AddBillDTO());
		return "add";
	}

	@PostMapping("/add")
	public String saveBill(@ModelAttribute("registerForm") @Valid AddBillDTO addBillDTO,
	                       BindingResult bindingResult, HttpSession session,
	                       BillDetailsDTO billDetailsDTO){
		UserDTO userDTO = (UserDTO) session.getAttribute("logged-user");
		User user = userRepository.findOne(userDTO.getId());

		boolean test = false;
		LocalDate date = addBillDTO.getDate();
		System.out.println("DATA  " + date);
		System.out.println(billService.isdateValid(addBillDTO));
		if(bindingResult.hasErrors()){
			return "add";
		}
		if (billService.isdateValid(addBillDTO)) {
			bindingResult.rejectValue("date","", "Zła data");
			return "add";
		}

		Bill bill =  billService.saveBill(addBillDTO, user);
		billService.saveBillDetails(billDetailsDTO,bill, addBillDTO);

		return "redirect:/edit/"+bill.getId();



	}
}
