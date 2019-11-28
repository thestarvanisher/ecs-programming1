/**
 * Lab 9 part 1
 * Aurthor: Ivalin Chobanov
 * Email: ilc1u19@soton.ac.uk
 * */

import java.io.*;

public class FlashCardReader {

    BufferedReader reader;
    public FlashCardReader(String fileName) {
        try {
            reader = new BufferedReader(new FileReader(fileName));
        }
        catch (Exception e) {
            System.out.println("Error reading a file!");
        }
    }

    public String getLine() {
        try {
            return reader.readLine();
        }
        catch (Exception e) {
            System.out.println("Cannot read line from file");
            return null;
        }

    }

    public boolean fileIsReady() {
        try {
            return reader.ready();
        }
        catch (Exception e) {
            System.out.println("File cannot be checked for ready status!");
            return false;
        }
    }




    public static void main(String[] args) {

    }

}