package car_dealership;

public class Person {

	private String name;
	private String address;

	public Person(String name, String address) {
		this.setName(name);
		this.setAddress(address);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		// capitalize the name
		this.name = name.substring(0, 1).toUpperCase() + name.substring(1);;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}