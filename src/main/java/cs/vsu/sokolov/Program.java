package cs.vsu.sokolov;

import cs.vsu.sokolov.Logic.ListHandler;
import cs.vsu.sokolov.Logic.StringHandler;
import cs.vsu.sokolov.argsHeandler.CmdParams;
import cs.vsu.sokolov.argsHeandler.FileHandler.FileReader;
import cs.vsu.sokolov.argsHeandler.FileHandler.FileWriter;
import cs.vsu.sokolov.argsHeandler.ParamsReader;

import java.io.IOException;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        task(args);
    }

    public static void task (String[] args) {
        CmdParams params = ParamsReader.parseArgs(args);
        List<Integer> list1;
        List<Integer> list2;

        String[] strFromFile;

        try {
            strFromFile = FileReader.getFileData(params.inputFile);

            if (strFromFile.length < 1) {
                throw new Exception("Input File is Empty");
            }

            list1 = StringHandler.StringToIntsList(strFromFile[0]);
            list2 = StringHandler.StringToIntsList(strFromFile[1]);

            List<Integer> result;
            result = ListHandler.inList1NotInList2(list1, list2);

            FileWriter.writeStringToFile("out.txt", "src/main/resources/lists", result.toString());

        } catch (IOException e) {
            System.out.println("Error with FileReader");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
