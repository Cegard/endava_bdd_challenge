package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IO {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void writeStringInFile(String path, String content) {
        try {
            File file = new File(path);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
