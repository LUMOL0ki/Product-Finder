package vsb.vea.models;

public enum StatusType {
	SUBMITTED("Submitted"),
	REVIEWING("Reviewing"),
	APPROVED("Approved"),
	REJECTED("Rejected");

	private final String displayValue;
	
	StatusType(String displayValue) {
		// TODO Auto-generated constructor stub
		this.displayValue = displayValue;
	}
	
	public String getDisplayValue() {
		return this.displayValue;
	}
}
