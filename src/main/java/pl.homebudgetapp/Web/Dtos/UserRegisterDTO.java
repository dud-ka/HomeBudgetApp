package pl.homebudgetapp.Web.Dtos;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class UserRegisterDTO {

	@NotBlank(message = "Należy podać email")
	@NotNull(message = "Należy podać email")
	private String email;
	@NotBlank(message = "Należy podać hasło")
	@NotNull(message = "Należy podać hasło")
	private String password;
	@NotNull(message = "Należy powtórzyć hasło")
	@NotBlank(message = "Należy powtórzyć hasło")
	private String confirmPassword;
	@NotBlank(message = "Należy podać nazwę użytkownika")
	@NotNull(message = "Należy podać nazwę użytkownika")
	private String username;

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
