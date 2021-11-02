package car_dealership;

public class Vehicle {
	private double price;
	private String make;
	private int year;
	
	public Vehicle(double price, String make, int year) {
		super();
		this.setPrice(price);
		this.setMake(make);
		this.setYear(year);
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

}
