import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MemoryGame
{
    private static String[] generate(int size) {
        String l = "1234567890";
        String[] random = new String[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            int next = r.nextInt(10);
            random[i] = Character.toString(l.charAt(next));
        }
        return random;
    }
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        int numbers = Integer.parseInt(JOptionPane.showInputDialog(frame, "How many numbers should be displayed?"));
        int time = Integer.parseInt(JOptionPane.showInputDialog(frame, "How much time should the first number be displayed for?")); 
        //pop up windows asking for user input

        MemoryGameGUI screen = new MemoryGameGUI();
        screen.createBoard(numbers, false); //creates gameboard
        int score = 0;
        int round = 0;
        while(true) {
            String[] pattern = generate(numbers);
            String input = screen.playSequence(pattern, time);
            String answer = String.join("", pattern);
            if(answer.equals(input)) {
                screen.matched();
                score++;
            }
            round++;
            if (!screen.playAgain()) break;
        }
        screen.showScore(score, round);

    }
}