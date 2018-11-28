package pl.homebudgetapp.Web.Dtos;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class UserLoginDTO {

	@NotBlank(message = "Należy podać email")
	@NotNull(message = "Należy podać email")
	private String email;
	@NotBlank(message = "Należy podać hasło")
	@NotNull(message = "Należy podać hasło")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
