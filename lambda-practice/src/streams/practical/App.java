package streams.practical;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach((x) -> System.out.print(x));
        System.out.println();

        Stream.of("hello", "bottle", "xyz")
                .sorted()
                .findFirst()
                .ifPresent((x) -> System.out.println(x));

        String[] items = {"car", "computer", "box", "pencil", "pen"};
        Stream.of(items)
                .filter((x) -> x.startsWith("p"))
                .sorted()
                .forEach((x) -> System.out.print(x + ", "));
        System.out.println();

        Arrays.stream(new int[] {2, 4, 6, 8, 10})
                .map((x) -> x * x)
                .average()
                .ifPresent((x) -> System.out.print(x));
        System.out.println();

        List<String> listOfItems = Arrays.asList("Computer", "Box", "Pencil", "Toy", "Car");
        listOfItems.stream()
                .map(x -> x.toLowerCase(Locale.ROOT))
                .filter(x -> x.startsWith("c"))
                .sorted()
                .forEach(x -> System.out.print(x + " "));
        System.out.println();

        try (Stream<String> lines = Files.lines(Paths.get("data/wordFile.txt"));) {
            lines
                .filter(l -> l.length() > 6)
                .sorted()
                .forEach(x -> System.out.print(x + " "));
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Stream<String> lines = Files.lines(Paths.get("data/wordFile.txt"));) {
            List<String> words = lines
                    .filter(x -> x.contains("th"))
                    .collect(Collectors.toList());
            System.out.println(words);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Stream<String> rows = Files.lines(Paths.get("data/stockDataCsv.txt")); ) {
            int rowCount = (int) rows
                    .map(x -> x.split(","))
                    .filter(x -> x.length > 3)
                    .count();
            System.out.println(rowCount + " rows");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Stream<String> rows = Files.lines(Paths.get("data/stockDataCsv.txt")); ) {
            rows.map(x -> x.split(","))
                    .filter(x -> x.length > 3)
                    .filter(x -> Integer.parseInt(x[1].trim()) > 15)
                    .forEach(x -> System.out.println(x[0].trim() + " " + x[2].trim() + " " + x[3].trim()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
