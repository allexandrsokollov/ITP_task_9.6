package cs.vsu.sokolov.Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringHandler {

    public static List<Integer> StringToIntsList (String str) {
        Scanner scanner = new Scanner(str);
        List<Integer> result = new ArrayList<>();

        while (scanner.hasNextInt()) {
            result.add(scanner.nextInt());
        }
        return result;
    }

    public static String IntListToString(List<Integer> list) {
        StringBuilder result = new StringBuilder();

        for (Integer i : list) {
            result.append(i);
            result.append(" ");
        }

        return result.toString();
    }

}
