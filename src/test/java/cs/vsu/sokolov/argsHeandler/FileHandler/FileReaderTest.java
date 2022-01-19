package cs.vsu.sokolov.argsHeandler.FileHandler;

import cs.vsu.sokolov.FileHandler.FileReader;
import org.junit.Assert;

import java.io.IOException;

public class FileReaderTest {

    @org.junit.Test
    public void getFileData() {


        String[] expected1 = new String[] {"1 1 1 1 1 1 1 1", "2 2 2 2 2"};
        String[] expected2 = new String[] {"1 1 1 1"};
        String[] expected3 = new String[] {};

        try {
            Assert.assertArrayEquals(expected1,
                    FileReader.getFileData("src/main/resources/filesToTestFileReader/1.txt"));

            Assert.assertArrayEquals(expected2,
                    FileReader.getFileData("src/main/resources/filesToTestFileReader/2.txt"));

            Assert.assertArrayEquals(expected3,
                    FileReader.getFileData("src/main/resources/filesToTestFileReader/3.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}