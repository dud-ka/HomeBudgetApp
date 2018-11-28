package pl.homebudgetapp.Service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.homebudgetapp.Entity.User;
import pl.homebudgetapp.Repository.UserRepository;
import pl.homebudgetapp.Web.Dtos.UserDTO;

import javax.security.auth.login.Configuration;
import javax.transaction.Transactional;
import java.util.logging.ConsoleHandler;

@Service
@Transactional
public class LoginService {

	@Autowired
	UserRepository userRepository;

	public UserDTO login(String email, String password) {
		if(email == null | email.isEmpty()) {
			return null;
		}
		if(password == null | email.isEmpty()) {
			return null;
		}
		User user = userRepository.findAllByEmail(email);
		if(user == null) {
			return null;
		}

		boolean bcrypt = BCrypt.checkpw(password, user.getPassword());

		System.out.println("BCRYPT   " + bcrypt);
		if(!bcrypt){
			return null;
		}

		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setEmail(user.getEmail());
		userDTO.setUsername(user.getUsername());

		return userDTO;

	}

}
