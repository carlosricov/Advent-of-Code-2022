package Day7;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        File smallFile = new File("./Day7/input-small.txt");
        File mainFile = new File("./Day7/input.txt");

        Scanner smallReader = new Scanner(smallFile);
        Scanner mainReader = new Scanner(mainFile);

        List<String> smallInput = new ArrayList<>();
        List<String> mainInput = new ArrayList<>();

        while (smallReader.hasNext()) {
            smallInput.add(smallReader.nextLine());
        }

        while (mainReader.hasNext()) {
            mainInput.add(mainReader.nextLine());
        }


        smallReader.close();
        mainReader.close();
    }
}