package Day1;

import java.util.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {

    public static long returnHighestElfCaloriesPart1(List<Long> input) {
        Collections.sort(input);

        return input.get(input.size() - 1);
    }

    public static void printTopThreeCaloriesPart2(List<Long> input) {
        Collections.sort(input);
        long total = input.get(input.size() - 1) + input.get(input.size() - 2) + input.get(input.size() - 3);

        System.out.println("Highest: " + input.get(input.size() - 1));
        System.out.println("Second Highest: " + input.get(input.size() - 2));
        System.out.println("Third Highest: " + input.get(input.size() - 3));
        System.out.println("Total: " + total);
    }

    public static void main(String[] args) throws Exception {
        Path filePath = Paths.get("./Day1/input.txt");
        List<String> lines = Files.readAllLines(filePath);
        List<Long> totalCals = new ArrayList<>();
        long currentCals = 0;

        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                currentCals += Long.parseLong(line);
            } else {
                totalCals.add(currentCals);
                currentCals = 0;
            }
        }

        System.out.println("Highest Cals: " + returnHighestElfCaloriesPart1(totalCals));
        printTopThreeCaloriesPart2(totalCals);

    }
}
