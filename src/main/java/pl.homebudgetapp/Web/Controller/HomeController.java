package pl.homebudgetapp.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.homebudgetapp.Service.BillDetailsService;
import pl.homebudgetapp.Web.Dtos.UserDTO;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	BillDetailsService billDetailsService;

	@GetMapping
	public String home() {
		return "redirect:/login";
	}

	@GetMapping("/main")
	public String mainpage(Model model,
	                       @SessionAttribute(value = LoginController.LOGGED_USER_KEY,
			                       required = false) UserDTO loggedUser) {
		if(loggedUser != null) {
			model.addAttribute("loggedUser", loggedUser);
			model.addAttribute("userBills", billDetailsService.billList(loggedUser));
		}
		if(loggedUser == null){
			return "redirect:/login";
		}
		return "index";
	}
}
