package subway.user.model.dto;

public class VegetablesDTO {
	private String vegId;
	private String vegName;
	private int vegAmount;
	private String oderId;
	
	public VegetablesDTO() {}
	
	public VegetablesDTO(String vegId, String vegName, int vegAmount, String oderId) {
		super();
		this.vegId = vegId;
		this.vegName = vegName;
		this.vegAmount = vegAmount;
		this.oderId = oderId;
	}

	public String getVegId() {
		return vegId;
	}

	public void setVegId(String vegId) {
		this.vegId = vegId;
	}

	public String getVegName() {
		return vegName;
	}

	public void setVegName(String vegName) {
		this.vegName = vegName;
	}

	public int getVegAmount() {
		return vegAmount;
	}

	public void setVegAmount(int vegAmount) {
		this.vegAmount = vegAmount;
	}

	public String getOderId() {
		return oderId;
	}

	public void setOderId(String oderId) {
		this.oderId = oderId;
	}

	@Override
	public String toString() {
		return vegId + " | " + vegName + " | " + vegAmount + " | "
				+ oderId;
	}
	
	
	
}
