public class Order {
	private Sandwich userSandwich;
	private String timeStamp;
	private String customerName;
	
	public Order(Sandwich userSandwich, String timeStamp, String customerName) {
		this.userSandwich = userSandwich;
		this.timeStamp = timeStamp;
		this.customerName = customerName;
	}
	
	public String printOrder() {
		return timeStamp + ", " + customerName + "; " + userSandwich.getBread() + ", " + userSandwich.getVeggies() + userSandwich.getMeat() + "; $" + userSandwich.getPrice();
	}
}

