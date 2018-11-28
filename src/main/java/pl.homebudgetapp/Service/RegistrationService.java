package pl.homebudgetapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.homebudgetapp.Entity.User;
import pl.homebudgetapp.Repository.UserRepository;
import pl.homebudgetapp.Web.Dtos.UserRegisterDTO;

import javax.transaction.Transactional;


@Service
@Transactional
public class RegistrationService {

	@Autowired
	UserRepository userRepository;

	public boolean checkEmail(String email){
		if(email == null || email.isEmpty()) {
			return false;
		}

		User user = userRepository.findAllByEmail(email);

		// OK - user doesn't exist
		return user == null;

	}

	public void register(UserRegisterDTO userRegisterDTO) {
		User user = new User();
		user.setEmail(userRegisterDTO.getEmail());
		user.setPassword(userRegisterDTO.getPassword()); //set hashed password
		user.setUsername(userRegisterDTO.getUsername());

		userRepository.save(user);
	}

	// TODO: 28.11.18  dodaj mu kategorie wydatków

}
