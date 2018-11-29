package pl.homebudgetapp.Web.Dtos;

import java.util.List;

public class BillDTO {

	private Long id;
	private List<BillDetailsDTO> detailsDTOS;
	private Double total;
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<BillDetailsDTO> getDetailsDTOS() {
		return detailsDTOS;
	}

	public void setDetailsDTOS(List<BillDetailsDTO> detailsDTOS) {
		this.detailsDTOS = detailsDTOS;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
