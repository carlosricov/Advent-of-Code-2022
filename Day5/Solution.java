package Day5;

import java.util.*;
import java.io.*;

public class Solution {
    static Stack<String> column1 = new Stack<>();
    static Stack<String> column2 = new Stack<>();
    static Stack<String> column3 = new Stack<>();
    static Stack<String> column4 = new Stack<>();
    static Stack<String> column5 = new Stack<>();
    static Stack<String> column6 = new Stack<>();
    static Stack<String> column7 = new Stack<>();
    static Stack<String> column8 = new Stack<>();
    static Stack<String> column9 = new Stack<>();

    static List<Stack> listOfColumns = new ArrayList<>();

    public static void part1(List<String> input) {
        String outputMsg = "";

        for (String line : input) {
            System.out.println("Line: " + line);
            String[] lineParts = line.split(" ");

            int moveCounter = Integer.parseInt(lineParts[1]);
            int fromColumn = Integer.parseInt(lineParts[3]);
            int toColumn = Integer.parseInt(lineParts[5]);

            for (int i = 0; i < moveCounter; i++) {
                String crate = (String) listOfColumns.get(fromColumn - 1).pop();
                Stack<String> column = listOfColumns.get(toColumn - 1);

                column.push(crate);
            }
        }

        for (Stack s : listOfColumns) {
            outputMsg += (String) s.peek();
        }

        System.out.println(outputMsg);
    }

    public static void part2(List<String> input) {
        String outputMsg = "";

        for (String line : input) {
            System.out.println("Line: " + line);
            String[] lineParts = line.split(" ");

            int moveCounter = Integer.parseInt(lineParts[1]);
            int fromColumn = Integer.parseInt(lineParts[3]);
            int toColumn = Integer.parseInt(lineParts[5]);

            Stack<String> crane = new Stack<>();

            for (int i = 0; i < moveCounter; i++) {
                String crate = (String) listOfColumns.get(fromColumn - 1).pop();
                crane.push(crate);
            }

            while (!crane.isEmpty()) {
                listOfColumns.get(toColumn - 1).push(crane.pop());
            }

        }

        for (Stack s : listOfColumns) {
            outputMsg += (String) s.peek();
        }

        System.out.println(outputMsg);
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("./Day5/input.txt");
        Scanner in = new Scanner(inputFile);

        column1.push("G");
        column1.push("T");
        column1.push("R");
        column1.push("W");

        column2.push("G");
        column2.push("C");
        column2.push("H");
        column2.push("P");
        column2.push("M");
        column2.push("S");
        column2.push("V");
        column2.push("W");

        column3.push("C");
        column3.push("L");
        column3.push("T");
        column3.push("S");
        column3.push("G");
        column3.push("M");

        column4.push("J");
        column4.push("H");
        column4.push("D");
        column4.push("M");
        column4.push("W");
        column4.push("R");
        column4.push("F");

        column5.push("P");
        column5.push("Q");
        column5.push("L");
        column5.push("H");
        column5.push("S");
        column5.push("W");
        column5.push("F");
        column5.push("J");

        column6.push("P");
        column6.push("J");
        column6.push("D");
        column6.push("N");
        column6.push("F");
        column6.push("M");
        column6.push("S");

        column7.push("Z");
        column7.push("B");
        column7.push("D");
        column7.push("F");
        column7.push("G");
        column7.push("C");
        column7.push("S");
        column7.push("J");

        column8.push("R");
        column8.push("T");
        column8.push("B");

        column9.push("H");
        column9.push("N");
        column9.push("W");
        column9.push("L");
        column9.push("C");

        listOfColumns.add(column1);
        listOfColumns.add(column2);
        listOfColumns.add(column3);
        listOfColumns.add(column4);
        listOfColumns.add(column5);
        listOfColumns.add(column6);
        listOfColumns.add(column7);
        listOfColumns.add(column8);
        listOfColumns.add(column9);

        List<String> inputList = new ArrayList<>();

        while (in.hasNextLine()) {
            String line = in.nextLine();
            inputList.add(line);
        }

        // part1(inputList);
        part2(inputList);

        in.close();
    }
}
