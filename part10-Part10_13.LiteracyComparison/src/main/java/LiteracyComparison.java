
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class LiteracyComparison {

    public static void main(String[] args) {
        List<Country> list = parseAFile();
        list = sort(list);
        printList(list);


    }

    public static List<Country> parseAFile() {
        List<String> list = new ArrayList<>();
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .forEach(row -> list.add(row));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        List<Country> countryList = list.stream()
                .map(row -> row.split(","))
                .filter(rows -> rows.length == 6)
                .map(parts -> new Country(parts[3], deletePercent(parts[2]), Integer.parseInt(parts[4]), Double.parseDouble(parts[5])))
                .collect(Collectors.toCollection(ArrayList::new));
        return countryList;
    }

    public static String deletePercent(String string) {
        if (string.contains("female")) {
            return "female";
        } else if (string.contains("male")) {
            return "male";
        }
        return null;
    }

    public static List<Country> sort(List<Country> list) {
        List<Country> countryList = list.stream()
                .sorted((p1,p2)->compareTo(p1.getPercent(),p2.getPercent()))
                .collect(Collectors.toCollection(ArrayList::new));
        return countryList;

    }

    public static int compareTo(double p1, double p2) {
        if (p1 < p2) {
            return -1;
        } else if (p2 < p1) {
            return 1;
        } else {
            return 0;

        }
    }

    public static void printList(List<Country> list) {
        list.stream()
                .forEach(row -> System.out.println(row));
    }
}

