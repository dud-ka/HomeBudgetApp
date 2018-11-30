package pl.homebudgetapp.Web.Dtos;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AddBillDTO {


	@NotNull
	private LocalDate date;
	@NotNull(message = "Wiersz nie może być pusty")
	private Double total;
	@NotNull(message = "Wiersz nie może być pusty")
	@NotBlank(message = "Wiersz nie może być pusty")
	private String description;
	private Long userId;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
