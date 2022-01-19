package lambda.practical;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("Honda", "Accord", "Red", 22300),
                new Car("Honda", "Civic", "Blue", 17700),
                new Car("Toyota", "Land Cruiser", "White", 48500),
                new Car("Toyota", "Corolla", "Black", 16200),
                new Car("Toyota", "Camry", "Blue", 24000),
                new Car("Nissan", "Sentra", "White", 17300),
                new Car("Mitsubishi", "Lancer", "White", 20000),
                new Car("Jeep", "Wrangler", "Red", 24500)
        );

        printCarsPriceRange(cars, 18000, 25000);
        printCarByColor(cars, "Red");
        System.out.println("Lambdas......");
        printCars(cars, (c) -> {
            return 18000 <= c.getPrice() && c.getPrice() <= 25000;
        });
        printCars(cars, (c) -> c.getColor().equals("Red"));

        Function<Car, String> priceAndColor = (c) -> "price = " + c.getPrice() + ", color = " + c.getColor();
        priceAndColor.apply(cars.get(0));
    }

    public static void printCarsPriceRange(List<Car> cars, int low, int high) {
        for(Car c: cars) {
            if(low <= c.getPrice() && c.getPrice() <= high) {
                c.printCar();
            }
        }
    }

    public static void printCarByColor(List<Car> cars, String color) {
        for(Car c: cars) {
            if(c.getColor().equals(color)) {
                c.printCar();
            }
        }
    }

    // public static void printCars(List<Car> cars, Condition<Car> condition) {
    public static void printCars(List<Car> cars, Predicate<Car> condition) {
        for (Car c : cars) {
            if (condition.test(c)) {
                c.printCar();
            }
        }
    }
}


@FunctionalInterface
interface Condition<T> {
    public boolean test(T t);
}
