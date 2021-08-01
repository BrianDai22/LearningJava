package SchoolWork.IntroToJava;

//Author: Brian Dai
//HangManDriver

//import swing to use JOptionPane and GUI functions
import javax.swing.*;
//public class to hold the main function
public class HangManDriver {
    //main method to run the JFrame
    public static void main(String[] args) {
        //setup the frame
        JFrame frame = new JFrame("Hangman");
        //add the jPanel
        frame.add(new Hangman());
        //pack the frame
        frame.pack();
        //set the frame visible so the user can see
        frame.setVisible(true);
    }
}
