package cs.vsu.sokolov.argsHeandler.FileHandler;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileWriterTest {

    @Test
    public void writeStringToFileTest() {

        String write1 = new String ("1 1 1 1 1 1 1 1\n2 2 2 2 2");
        String write2 = new String("1 1 1 1");

        String[] expected1 = new String[] {"1 1 1 1 1 1 1 1", "2 2 2 2 2"};
        String[] expected2 = new String[] {"1 1 1 1"};

        try {
            FileWriter.writeStringToFile("1", write1);
            FileWriter.writeStringToFile("2", write2);

            Assert.assertArrayEquals(expected1,
                    FileReader.getFileData("src/main/resources/filesToTestFileWriter/1.txt"));

            Assert.assertArrayEquals(expected2,
                    FileReader.getFileData("src/main/resources/filesToTestFileWriter/2.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}