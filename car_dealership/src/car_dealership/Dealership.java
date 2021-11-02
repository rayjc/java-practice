package car_dealership;

public class Dealership {

	public static void main(String[] args) {
		Employee emp1 = new Employee("Henry", "123 London Boulevard");
		Vehicle car1 = new Vehicle(50000, "Porsche", 2015);
		Customer cust1 = new Customer("Toto", "201 Baker Street", 100000);
		
		cust1.purchase(car1, emp1, false);
	}

}
