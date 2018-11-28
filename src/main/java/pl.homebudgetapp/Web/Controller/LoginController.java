package pl.homebudgetapp.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.homebudgetapp.Service.LoginService;
import pl.homebudgetapp.Web.Dtos.UserDTO;
import pl.homebudgetapp.Web.Dtos.UserLoginDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

	public static final String LOGGED_USER_KEY= "logged-user";

	@Autowired
	LoginService loginService;

	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("loginForm", new UserLoginDTO());
		return "/login";
	}

	@PostMapping("/login")
	public String loginUser(@ModelAttribute("loginForm") @Valid UserLoginDTO userLoginDTO,
	                        BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors()){
			return "/login";
		}
		UserDTO userDTO = loginService.login(userLoginDTO.getEmail(), userLoginDTO.getPassword());
//		boolean credentials = loginService.checkCredentials(userLoginDTO.getEmail(), userLoginDTO.getPassword());
		if(userDTO == null){
			bindingResult.rejectValue("email", "", "Email lub hasło nieprawidłowe");
			return "/login";
		}

		session.setAttribute(LOGGED_USER_KEY, userDTO);
		System.out.println("zalogowano " + userDTO.getUsername());
		return "redirect:/main";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
