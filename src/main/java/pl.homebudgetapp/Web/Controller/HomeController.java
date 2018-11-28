package pl.homebudgetapp.Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.homebudgetapp.Web.Dtos.UserDTO;

@Controller
@RequestMapping("/")
public class HomeController {

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
//			model.addAttribute("allTweets", tweetService.tweetList());
//			model.addAttribute("addTweet", new TweetDTO());
		}
		return "index";
	}
}
