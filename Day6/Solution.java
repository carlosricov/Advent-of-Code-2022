package Day6;

import java.util.*;
import java.io.*;

public class Solution {

    private static boolean isUnique(String packet) {
        Set<Character> lettersSeen = new HashSet<>();
        char[] letters = packet.toCharArray();

        for (char letter : letters) {
            if (lettersSeen.contains(letter)) {
                return false;
            }
            else {
                lettersSeen.add(letter);
            }
        }

        return true;
    }

    public static void part1(String sequence) {
        // Assign temporary string of 4 letters
        String tempString = "";
        
        int startIndex = 0;
        int endIndex = 4;


        // Loop: [0, 4] .. [1, 5] .. [2, 6]
        // Start at 0, stop when boundary > sequence length

        while (endIndex <= sequence.length()) {
            String packet = sequence.substring(startIndex, endIndex);

            // Check if packet contains unique letters, if true exit out of loop.
            if (isUnique(packet)) {
                System.out.println("The start of sequence is " + (endIndex));
                
                break;
            }

            startIndex++;
            endIndex++;
        }
    }

    public static void part2(String sequence) {
        // Assign temporary string of 4 letters
        String tempString = "";
        
        int startIndex = 0;
        int endIndex = 14;


        // Loop: [0, 4] .. [1, 5] .. [2, 6]
        // Start at 0, stop when boundary > sequence length

        while (endIndex <= sequence.length()) {
            String packet = sequence.substring(startIndex, endIndex);

            // Check if packet contains unique letters, if true exit out of loop.
            if (isUnique(packet)) {
                System.out.println("The start of sequence is " + (endIndex));
                
                break;
            }

            startIndex++;
            endIndex++;
        }
    }
    
    public static void main(String[] args) throws Exception {
        File inputSmall = new File("./Day6/input-small.txt");
        File input = new File("./Day6/input.txt");
        
        Scanner smallScanner = new Scanner(inputSmall);
        Scanner scanner = new Scanner(input);
        
        String smallSequence = smallScanner.nextLine();
        String sequence = scanner.nextLine();

        part1(smallSequence);
        part1(sequence);

        part2(smallSequence);
        part2(sequence);
        
        smallScanner.close();
    }
}