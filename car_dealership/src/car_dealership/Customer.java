package car_dealership;

public class Customer extends Person {
	
	private double cashOnHand;
	private double debt;
	
	public Customer(String name, String address) {
		this(name, address, 0, 0);
	}


	public Customer(String name, String address, double cashOnHand) {
		this(name, address, cashOnHand, 0);
	}


	public Customer(String name, String address, double cashOnHand, double debt) {
		super(name, address);
		this.setCashOnHand(cashOnHand);
		this.setDebt(debt);
	}


	public double getCashOnHand() {
		return cashOnHand;
	}
	
	public double getDebt() {
		return debt;
	}


	public void purchase(Vehicle vehicle, Employee emp, boolean finance) {
		System.out.printf("Customer %s purchasing %s...\n", getName(), vehicle.getMake() + ' ' + vehicle.getPrice());
		emp.handleCustomer(this, vehicle, finance);
	}


	public void setCashOnHand(double cashOnHand) {
		this.cashOnHand = cashOnHand;
	}


	public void setDebt(double debt) {
		this.debt = debt;
	}

}
