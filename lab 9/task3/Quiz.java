/**
 * Lab 9 part 3
 * Aurthor: Ivalin Chobanov
 * Email: ilc1u19@soton.ac.uk
 * */

import java.util.*;
import java.io.*;

public class Quiz {

    FlashCardReader reader;
    ArrayList<FlashCard> flashCards;
    String outputFileName = "save.txt";
    BufferedWriter writer;

    /**
     * The constructor to the class, takes the name of the file
     * @param fileName the name of the file to read the questions and answers from
     * */
    public Quiz(String fileName) {
        this.reader = new FlashCardReader(fileName);
        this.flashCards = reader.getFlashCards();
        play();
    }

    /**
     * The play method starts the game
     * */
    public void play() {

        // The saveSelect variable gives information whether the player wants the result saved
        Toolbox myToolbox = new Toolbox();
        boolean saveSelect = false;

        // Here the player is required to select yes or no
        while(true) {
            System.out.println("Would you like to save your results? 'Y' for yes, 'N' for no");
            String selection = myToolbox.readStringFromCmd();
            if(selection.equals("Y")) {
                saveSelect = true;
                break;
            }
            else if(selection.equals("N")) {
                saveSelect = false;
                break;
            }
            else {
                continue;
            }
        }

        this.save(saveSelect);
        int correctAnswers = 0;

        // Here a question is given and and the player answers it
        for(int i = 0; i < flashCards.size(); i++) {
            System.out.println(flashCards.get(i).getQuestion());
            String userAnswer = myToolbox.readStringFromCmd();
            if(userAnswer.equals(flashCards.get(i).getAnswer())) {
                System.out.println("right");
                correctAnswers++;
                save(flashCards.get(i).getQuestion(), userAnswer, "right", saveSelect);
            }
            else {
                System.out.println("wrong. Answer is " + flashCards.get(i).getAnswer());
                System.out.println();
                save(flashCards.get(i).getQuestion(), userAnswer, "wrong", saveSelect);
            }
        }
        save(correctAnswers, flashCards.size(), (double)(((double)correctAnswers/(double)flashCards.size())*100), saveSelect);
    }

    /**
     * This method saves the question, player answer and whether it was right or wrong
     * @param question the question
     * @param answer the answer provided by the player
     * @param status whether the answer was right or wrong
     * @param saveStatus true for save, false if the user doesn't want to
     * */
    public void save(String question, String answer, String status, boolean saveStatus) {
        if(saveStatus == false) return;
        try {
            this.writer = new BufferedWriter(new FileWriter(this.outputFileName, true));
            this.writer.write("" + question + "," + answer + "," + status + "\n");
            this.writer.close();
        }
        catch (Exception e) {
            System.out.println("Error saving question to file!");
        }
    }

    /**
     * This method saves the correct answers, total questions, percentage of correct answers
     * @param correctAnswers number of correct answers
     * @param totalQuestions number of total questions
     * @param percentage the percentage of correct answers
     * @param saveStatus true for save, false if the user doesn't want to
     * */
    public void save(int correctAnswers, int totalQuestions, double percentage, boolean saveStatus) {
        if(saveStatus == false) return;
        try {
            this.writer = new BufferedWriter(new FileWriter(this.outputFileName, true));
            this.writer.write("" + correctAnswers + "," + totalQuestions + "," + percentage);
            this.writer.close();
        }
        catch (Exception e) {
            System.out.println("Error saving number of correct answers!");
        }
    }

    /**
     * This method opens the file and flushes the content
     * @param saveStatus true for save, false if the user doesn't want to
     * */
    public void save(boolean saveStatus) {
        if(saveStatus == false) return;
        try {
            this.writer = new BufferedWriter(new FileWriter(this.outputFileName));
            this.writer.write("");
            this.writer.close();
        }
        catch (Exception e) {
            System.out.println("Error cleaning a file!");
        }
    }


    /**
     * The entry point of the program
     * */
    public static void main(String[] args) {
        Quiz quiz = new Quiz("Questions.txt");
    }

}