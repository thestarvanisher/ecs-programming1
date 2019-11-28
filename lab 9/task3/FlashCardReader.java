/**
 * Lab 9 part 3
 * Aurthor: Ivalin Chobanov
 * Email: ilc1u19@soton.ac.uk
 * */

import java.io.*;
import java.util.*;

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

    public ArrayList<FlashCard> getFlashCards (){
        ArrayList<FlashCard> flashCards = new ArrayList<FlashCard>();

        while(true) {
            String line = getLine();
            if(line == null) {
                break;
            }
            String question = line.substring(0, line.indexOf("?:"));
            String answer = line.substring(line.indexOf("?:") + 2);
            flashCards.add(new FlashCard(question, answer));
        }

        return flashCards;
    }

    public static void main(String[] args) {

    }

}