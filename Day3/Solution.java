package Day3;

import java.util.*;
import java.io.*;

class Item {
    public boolean isInSack1;
    public boolean isInSack2;
    public boolean isInSack3;
    public char item;
    public int priority;

    public Item(char item, int priority) {
        this.isInSack1 = false;
        this.isInSack2 = false;
        this.isInSack3 = false;
        this.item = item;
        this.priority = priority;
    }
}

public class Solution {
    public static int part1(List<String> sacks) {
        int sumOfPriority = 0;

        for (String sack : sacks) {
            Set<Character> set = new HashSet<>();
            int halfWay = (sack.length() / 2) - 1;

            for (int i = 0; i <= halfWay; i++) {
                set.add(sack.charAt(i));
            }

            for (int j = halfWay + 1; j < sack.length(); j++) {
                char item = sack.charAt(j);

                if (set.contains(item)) {
                    if (item < 97) {
                        sumOfPriority += (item - 'A' + 27);
                    } else {
                        sumOfPriority += (item - 'a' + 1);
                    }

                    break;
                }
            }
        }

        return sumOfPriority;
    }

    public static int part2(List<String> sacks) {
        List<List<String>> groups = new ArrayList<>();
        List<String> group = new ArrayList<>();
        Map<Character, Item> map;

        int lineCount = 0;
        int totalPriority = 0;

        for (String sack : sacks) {
            if (lineCount < 3) {
                System.out.println("Adding " + sack + " to group.");
                group.add(sack);
                lineCount++;

                if (lineCount >= 3) {
                    groups.add(group);
                    lineCount = 0;
                    group = new ArrayList<>();
                }
            }
        }

        for (List<String> g : groups) {
            map = new HashMap<>();
            char lowerCaseItem = 'a';
            char upperCaseItem = 'A';

            for (int i = 0; i < 52; i++) {
                if (i < 26) {
                    map.put(lowerCaseItem, new Item(lowerCaseItem, i + 1));
                    lowerCaseItem++;
                } else {
                    map.put(upperCaseItem, new Item(upperCaseItem, i + 1));
                    upperCaseItem++;
                }
            }

            for (int j = 0; j < 3; j++) {
                String sack = g.get(j);

                if (j == 0) {
                    for (int k = 0; k < sack.length(); k++) {
                        char c = sack.charAt(k);
                        Item item = map.get(c);
                        item.isInSack1 = true;
                    }
                } else if (j == 1) {
                    for (int k = 0; k < sack.length(); k++) {
                        char c = sack.charAt(k);
                        Item item = map.get(c);
                        item.isInSack2 = true;
                    }
                } else {
                    for (int k = 0; k < sack.length(); k++) {
                        char c = sack.charAt(k);
                        Item item = map.get(c);

                        if (item.isInSack1 && item.isInSack2) {
                            totalPriority += item.priority;
                            System.out.println("Same item found: " + item.item);
                            break;
                        }

                    }
                }
            }
        }

        return totalPriority;
    }

    public static void main(String[] args) throws Exception {
        File smallInput = new File("./Day3/input.txt");
        Scanner in = new Scanner(smallInput);

        List<String> sacks = new ArrayList<>();

        while (in.hasNext()) {
            sacks.add(in.nextLine());
        }

        System.out.println("Solution part 1: " + part1(sacks));
        System.out.println("Solution part 2: " + part2(sacks));
    }
}