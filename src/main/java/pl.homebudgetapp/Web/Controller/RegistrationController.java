package pl.homebudgetapp.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.homebudgetapp.Service.RegistrationService;
import pl.homebudgetapp.Web.Dtos.UserRegisterDTO;

import javax.validation.Valid;

@Controller
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("registerForm", new UserRegisterDTO());
		return "/register";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute("registerForm") @Valid UserRegisterDTO userRegisterDTO,
	                           BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "/register";
		}

		if(!checkPassword(userRegisterDTO)){
			bindingResult.rejectValue("confirmPassword","","Hasła muszą być takie same!");
			return "/register";
		}

		boolean emailChecking = registrationService.checkEmail(userRegisterDTO.getEmail());
		if(!emailChecking) {
			bindingResult.rejectValue("email", "","Użytkownik został już zarejestrowany");
			return "/register";
		}
		registrationService.register(userRegisterDTO);
		return "success";
	}

	private boolean checkPassword(UserRegisterDTO userRegisterDTO){
		return userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword());
	}

}
