/**
 * Lab 9 part 2
 * Aurthor: Ivalin Chobanov
 * Email: ilc1u19@soton.ac.uk
 * */

import java.util.*;

public class Quiz {

    FlashCardReader reader;
    ArrayList<FlashCard> flashCards;


    public Quiz(String fileName) {
        this.reader = new FlashCardReader(fileName);
        this.flashCards = reader.getFlashCards();
        play();
    }

    public void play() {
        Toolbox myToolbox = new Toolbox();

        for(int i = 0; i < flashCards.size(); i++) {
            System.out.println(flashCards.get(i).getQuestion());
            String userAnswer = myToolbox.readStringFromCmd();
            if(userAnswer.equals(flashCards.get(i).getAnswer())) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong. Answer is " + flashCards.get(i).getAnswer());
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz("Questions.txt");
    }

}