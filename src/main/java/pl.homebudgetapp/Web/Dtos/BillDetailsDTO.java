package pl.homebudgetapp.Web.Dtos;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class BillDetailsDTO {

	private Long id;
	private LocalDate date;
	private String description;
	private Double amount;
	@NotNull
	private String category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "BillDetailsDTO{" +
				"id=" + id +
				", date=" + date +
				", description='" + description + '\'' +
				", amount=" + amount +
				", category='" + category + '\'' +
				'}';
	}
}
