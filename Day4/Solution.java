package Day4;

import java.io.*;
import java.util.*;

public class Solution {

    public static int part1(List<String> pairs) {
        int totalPairs = 0;

        for (String pair : pairs) {
            int delimiter = pair.indexOf(",");
            String leftElf = pair.substring(0, delimiter);
            String rightElf = pair.substring(delimiter + 1, pair.length());

            // Left elf
            int leftElfDelimiter = leftElf.indexOf("-");
            int leftElfSectionStart = Integer.parseInt(leftElf.substring(0, leftElfDelimiter));
            int leftElfSectionEnd = Integer.parseInt(leftElf.substring(leftElfDelimiter + 1, leftElf.length()));

            // Right elf
            int rightElfDelimiter = rightElf.indexOf("-");
            int rightElfSectionStart = Integer.parseInt(rightElf.substring(0, rightElfDelimiter));
            int rightElfSectionEnd = Integer.parseInt(rightElf.substring(rightElfDelimiter + 1, rightElf.length()));

            // left elf to right elf
            if ((leftElfSectionStart >= rightElfSectionStart) && (leftElfSectionEnd <= rightElfSectionEnd)) {
                totalPairs++;
            } else if ((rightElfSectionStart >= leftElfSectionStart) && (rightElfSectionEnd <= leftElfSectionEnd)) {
                totalPairs++;
            }

        }

        return totalPairs;
    }

    public static int part2(List<String> pairs) {
        int totalPairs = 0;

        for (String pair : pairs) {
            int delimiter = pair.indexOf(",");
            String leftElf = pair.substring(0, delimiter);
            String rightElf = pair.substring(delimiter + 1, pair.length());

            // Left elf
            int leftElfDelimiter = leftElf.indexOf("-");
            int leftElfSectionStart = Integer.parseInt(leftElf.substring(0, leftElfDelimiter));
            int leftElfSectionEnd = Integer.parseInt(leftElf.substring(leftElfDelimiter + 1, leftElf.length()));

            // Right elf
            int rightElfDelimiter = rightElf.indexOf("-");
            int rightElfSectionStart = Integer.parseInt(rightElf.substring(0, rightElfDelimiter));
            int rightElfSectionEnd = Integer.parseInt(rightElf.substring(rightElfDelimiter + 1, rightElf.length()));

            if ((leftElfSectionStart >= rightElfSectionStart) && (leftElfSectionStart <= rightElfSectionEnd)) {
                System.out.println("Overlap Pair found: " + pair);
                totalPairs++;
            } else if ((rightElfSectionStart <= leftElfSectionEnd) && (rightElfSectionEnd >= leftElfSectionStart)) {
                System.out.println("Overlap pair found: " + pair);
                totalPairs++;
            }
        }

        return totalPairs;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("./Day4/input.txt");
        Scanner in = new Scanner(file);
        List<String> pairs = new ArrayList<>();

        while (in.hasNext()) {
            pairs.add(in.nextLine());
        }

        System.out.println("Answer part 1: " + part1(pairs));
        System.out.println("Answer part 2: " + part2(pairs));
    }
}
