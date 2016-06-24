package ac.service.pojo;

public class ReportGenerator {

	private String customerId;
	private String startDate;
	private String endDate;
	private String custName;
	private String amount;

	public ReportGenerator() {
		super();
	}

	public ReportGenerator(String customerId, String startDate, String endDate,
			String custName, String amount) {
		super();
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.custName = custName;
		this.amount = amount;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
