package Day2;

import java.io.*;
import java.util.*;

public class Solution {

    public static int part1(List<String> moves) {
        int totalScore = 0;

        for (String move : moves) {
            String opponentMove = move.substring(0, 1);
            String myMove = move.substring(2);

            if (opponentMove.equals("A") && myMove.equals("X"))
                totalScore += 4;
            else if (opponentMove.equals("A") && myMove.equals("Y"))
                totalScore += 8;
            else if (opponentMove.equals("A") && myMove.equals("Z"))
                totalScore += 3;
            else if (opponentMove.equals("B") && myMove.equals("X"))
                totalScore += 1;
            else if (opponentMove.equals("B") && myMove.equals("Y"))
                totalScore += 5;
            else if (opponentMove.equals("B") && myMove.equals("Z"))
                totalScore += 9;
            else if (opponentMove.equals("C") && myMove.equals("X"))
                totalScore += 7;
            else if (opponentMove.equals("C") && myMove.equals("Y"))
                totalScore += 2;
            else if (opponentMove.equals("C") && myMove.equals("Z"))
                totalScore += 6;
            else
                totalScore += 0;
        }

        return totalScore;
    }

    public static int part2(List<String> moves) {
        int totalScore = 0;

        for (String move : moves) {
            String opponentMove = move.substring(0, 1);
            String myMove = move.substring(2);

            if (opponentMove.equals("A") && myMove.equals("X"))
                totalScore += 3;
            else if (opponentMove.equals("A") && myMove.equals("Y"))
                totalScore += 4;
            else if (opponentMove.equals("A") && myMove.equals("Z"))
                totalScore += 8;
            else if (opponentMove.equals("B") && myMove.equals("X"))
                totalScore += 1;
            else if (opponentMove.equals("B") && myMove.equals("Y"))
                totalScore += 5;
            else if (opponentMove.equals("B") && myMove.equals("Z"))
                totalScore += 9;
            else if (opponentMove.equals("C") && myMove.equals("X"))
                totalScore += 2;
            else if (opponentMove.equals("C") && myMove.equals("Y"))
                totalScore += 6;
            else if (opponentMove.equals("C") && myMove.equals("Z"))
                totalScore += 7;
            else
                totalScore += 0;
        }

        return totalScore;
    }

    public static void main(String[] args) throws Exception {
        File inputFile = new File("./Day2/input.txt");
        Scanner in = new Scanner(inputFile);
        List<String> moves = new ArrayList<>();

        while (in.hasNext()) {
            moves.add(in.nextLine());
        }

        System.out.println("Total score for part 1: " + part1(moves));
        System.out.println("Total score for part 2: " + part2(moves));

        in.close();
    }
}
