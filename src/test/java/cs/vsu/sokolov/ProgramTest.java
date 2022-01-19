package cs.vsu.sokolov;

import cs.vsu.sokolov.FileHandler.FileReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ProgramTest {

    @Test
    public void taskTest() {

        String[] args1 = new String[] {
                "--inputFile", "src/main/resources/lists/f.txt",
                "--outputFile", "src/main/resources/lists/out.txt"
        };

        String[] args2 = new String[] {
                "--inputFile", "src/main/resources/lists/f2.txt",
                "--outputFile", "src/main/resources/lists/out2.txt"
        };


        String[] exp = new String[] {
                "[55, 77, 33, 2, 3, 4, 6, 7, 8, 0, 12, 44]"
        };
        String[] exp2 = new String[] {};

        try {
            Program.task(args1);
            Program.task(args2);

            Assert.assertArrayEquals(exp, FileReader.getFileData("src/main/resources/lists/out.txt"));
            Assert.assertArrayEquals(exp, FileReader.getFileData("src/main/resources/lists/out2.txt"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}