package car_dealership;

public class Employee extends Person {
	
	public Employee(String name, String address) {
		super(name, address);
	}
	
	public void handleCustomer(Customer cust, Vehicle vehicle, boolean finance) {
		if (finance) {
			runCreditCheck(cust, vehicle);
		} else if (vehicle.getPrice() <= cust.getCashOnHand()) {
			processTransaction(cust, vehicle);
		} else {
			System.out.println("Insufficient cash, please bring me more money!");
		}
	}
	
	private void processTransaction(Customer cust, Vehicle vehicle) {
		cust.setCashOnHand(cust.getCashOnHand() - vehicle.getPrice());
		System.out.printf("Customer %s has successfully bought the vehicle.\n", cust.getName());
	}

	private void runCreditCheck(Customer cust, Vehicle vehicle) {
		if (cust.getDebt() >= vehicle.getPrice()) {
			System.out.println("Customer has enough debt already...");
		}
		
		cust.setDebt(cust.getDebt() + vehicle.getPrice());
		System.out.printf("Customer %s has successfully financed the vehicle.\n", cust.getName());
	}

}
