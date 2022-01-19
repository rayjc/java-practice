public class App {

    public static void main(String[] args) {
        Human alpha = new Human();
        walker(alpha);

        Robot beta = new Robot();
        walker(beta);

        walker(new Walkable() {
            @Override
            public void walk() {
                System.out.println("Custom object from anonymous class walking...");
            }
        });

        // lambda can be used for functional interface
        // lambda can be used to disassociate methods from object/class (separate behavior)
        // To compete with other languages in data processing for working with collections!
        walker(() -> System.out.println("Custom object from lambda expression walking..."));

        // custom functional interfaces
        Calculate sumVar = (a, b) -> a + b;
        Calculate divVar = (a, b) -> {
            if (b == 0) {
                return 0;
            }
            return a / b;
        };

        System.out.println(sumVar.compute(1, 2));
        System.out.println(divVar.compute(2, 1));

        MyGenericInterface<String> reverser = (s) -> {
            StringBuilder result = new StringBuilder();
            for(int i = s.length() - 1; i >= 0; i--) {
                result.append(s.charAt(i));
            }
            return result.toString();
        };
        MyGenericInterface<Integer> factorial = (n) -> {
            int result = 1;
            if (n < 2) {
                return n;
            }
            for(int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        };

        System.out.println(reverser.work("abc"));
        System.out.println(factorial.work(5));
    }

    public static void walker(Walkable walkableEntity) {
        walkableEntity.walk();
    }
}

@FunctionalInterface
interface MyGenericInterface<T> {
    public T work(T x);
}