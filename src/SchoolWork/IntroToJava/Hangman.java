package SchoolWork.IntroToJava;

//Author: Brian Dai
//HangMan

//import Ellipse2D to be able to draw
import java.awt.geom.Ellipse2D;
//import swing to use JOptionPane and GUI functions
import javax.swing.*;
//import awt for useful tools for calculations like positioning of certain things
import java.awt.*;
//import awt.event for useful tools for user inputted actions like buttons
import java.awt.event.*;

//create class that extends into a JPanel so the user can actually play the game
public class Hangman extends JPanel {
    //most important variable that holds the word the user needs to guess in order to win
    private String word;
    //user variable which holds which letters were guessed correctly so far
    private String user;
    //variable that holds the number of incorrect guesses
    private int incorrect;
    //creates a text field for the user inputted guesses
    private JTextField input;
    //creates an output variable to show if the user guessed correctly
    private JLabel output;
    //creates a enter button to submit the character in the text field
    private JButton enterButton;
    //creates a variable to hold the hangManDrawing
    private HangMan hangManDrawing;
    //create a hangman constructor to hold everything

    public Hangman() {
        //this is the word we need to guess takes every type of character
        word = "Brian";
        //this is the underscores which is the word length
        user = spacer(word);
        //incorrect starts at 0 and then end at 8
        incorrect = 0;
        //textBox input size which displays 4 characters before scrolling to the right
        input = new JTextField(3);
        //create an enter button to input your guess
        enterButton = new JButton("enter");
        //add action listener for the enterButton so it does the event its supposed to do
        enterButton.addActionListener(new goAction());
        //create the output showing if you guessed correctly for
        output = new JLabel(user);
        //add the hangManDrawing to show if you guessed incorrectly and how many lives you have left
        hangManDrawing = new HangMan();
        //add input into the constructor
        this.add(input);
        //add enterButton into the constructor
        this.add(enterButton);
        //add output into the constructor
        this.add(output);
        //add hangManDrawing into the constructor
        this.add(hangManDrawing);
    }

    //this class will draw the actual hangman
    private class HangMan extends JPanel {
        //variable to use the timer functions so the hangman can keep on drawing and not disappear
        Timer repeatingCall;
        //whole hangman variable
        public HangMan() {
            //create the size of the hangman drawing
            this.setPreferredSize(new Dimension(250, 250));
            //infinitely draw in 50 milliseconds increments
            repeatingCall = new Timer(50, new timerAction());
            //start the loop
            repeatingCall.start();
        }
        //drawing variable
        public void paint(Graphics g) {
            //calls the superclass of paint to draw because
            //the background of the JPanel will shine through
            //and make it white if superclass isn't used
            super.paint(g);
            //variable to be able to draw a circle
            Ellipse2D.Double highQualityCircle = new Ellipse2D.Double();
            //anti aliasing for circles and lines so the edges of the pixels can be smooth and look better
            Graphics2D antiAliasing = (Graphics2D) g;
            //if one incorrect character was inputted
            if (incorrect == 1) {
                //draw hanging line thing that's not connected to hangman
                g.drawLine(110, 70, 150, 70);
            }
            //if two incorrect character was inputted
            if (incorrect == 2) {
                //draw hanging line thing that's not connected to hangman
                g.drawLine(110, 70, 150, 70);
                //draw the trunk of the gallow
                g.drawLine(150, 70, 150, 170);
                //draw the platform
                g.drawLine(135, 170, 165, 170);
            }
            //if three incorrect character was inputted
            if (incorrect == 3) {
                //draw hanging line thing that's not connected to hangman
                g.drawLine(110, 70, 150, 70);
                //draw the trunk of the gallow
                g.drawLine(150, 70, 150, 170);
                //draw the platform
                g.drawLine(135, 170, 165, 170);
                //draw the head
                highQualityCircle.width = 20;
                highQualityCircle.height = 20;
                highQualityCircle.x = 100;
                highQualityCircle.y = 80;
                antiAliasing.draw(highQualityCircle);
            }
            //if four incorrect character was inputted
            if (incorrect == 4) {
                //draw hanging line thing that's not connected to hangman
                g.drawLine(110, 70, 150, 70);
                //draw the trunk of the gallow
                g.drawLine(150, 70, 150, 170);
                //draw the platform
                g.drawLine(135, 170, 165, 170);
                //draw the head
                highQualityCircle.width = 20;
                highQualityCircle.height = 20;
                highQualityCircle.x = 100;
                highQualityCircle.y = 80;
                antiAliasing.draw(highQualityCircle);
                //draw the body
                g.drawLine(110, 100, 110, 130);
            }
            //if five incorrect character was inputted
            if (incorrect == 5) {
                //draw hanging line thing that's not connected to hangman
                g.drawLine(110, 70, 150, 70);
                //draw the trunk of the gallow
                g.drawLine(150, 70, 150, 170);
                //draw the platform
                g.drawLine(135, 170, 165, 170);
                //draw the head
                highQualityCircle.width = 20;
                highQualityCircle.height = 20;
                highQualityCircle.x = 100;
                highQualityCircle.y = 80;
                antiAliasing.draw(highQualityCircle);
                //draw the body
                g.drawLine(110, 100, 110, 130);
                //draw the arms
                g.drawLine(90, 110, 130, 110);
            }
            //if six incorrect character was inputted x
            if (incorrect == 6) {
                //draw hanging line thing that's not connected to hangman
                g.drawLine(110, 70, 150, 70);
                //draw the trunk of the gallow
                g.drawLine(150, 70, 150, 170);
                //draw the platform
                g.drawLine(135, 170, 165, 170);
                //draw the head
                highQualityCircle.width = 20;
                highQualityCircle.height = 20;
                highQualityCircle.x = 100;
                highQualityCircle.y = 80;
                antiAliasing.draw(highQualityCircle);
                //draw the body
                g.drawLine(110, 100, 110, 130);
                //draw the arms
                g.drawLine(90, 110, 130, 110);
                //draw the body
                g.drawLine(110, 130, 100, 160);
            }
            //if seven incorrect character was inputted
            if (incorrect == 7) {
                //draw hanging line thing that's not connected to hangman
                g.drawLine(110, 70, 150, 70);
                //draw the trunk of the gallow
                g.drawLine(150, 70, 150, 170);
                //draw the platform
                g.drawLine(135, 170, 165, 170);
                //draw the head
                highQualityCircle.width = 20;
                highQualityCircle.height = 20;
                highQualityCircle.x = 100;
                highQualityCircle.y = 80;
                antiAliasing.draw(highQualityCircle);
                //draw the body
                g.drawLine(110, 100, 110, 130);
                //draw the arms
                g.drawLine(90, 110, 130, 110);
                //draw the body
                g.drawLine(110, 130, 100, 160);
                //draw the second leg
                g.drawLine(110, 130, 120, 160);
            }
            //if eight incorrect character was inputted
            if (incorrect == 8) {
                //draw hanging line thing that's not connected to hangman
                g.drawLine(110, 70, 150, 70);
                //draw the trunk of the gallow
                g.drawLine(150, 70, 150, 170);
                //draw the platform
                g.drawLine(135, 170, 165, 170);
                //draw the head
                highQualityCircle.width = 20;
                highQualityCircle.height = 20;
                highQualityCircle.x = 100;
                highQualityCircle.y = 80;
                antiAliasing.draw(highQualityCircle);
                //draw the body
                g.drawLine(110, 100, 110, 130);
                //draw the arms
                g.drawLine(90, 110, 130, 110);
                //draw the body
                g.drawLine(110, 130, 100, 160);
                //draw the second leg
                g.drawLine(110, 130, 120, 160);
                //draw the line above the head
                g.drawLine(110, 80, 110, 70);
            }
        }
        //action class to actually draw and show the hangman based on the timer
        private class timerAction implements ActionListener {
            //draw every 50 milliseconds based on the repeatedCall variable
            public void actionPerformed(ActionEvent e) {
                //call the getGraphics() function
                Graphics g = getGraphics();
                //draw the hangman
                paint(g);
            }
        }
    }

    //builds the initial user input section
    private String spacer(String words) {
        //create a variable to place hold the indexes of the correct word
        String out = "";
        //loop to add the number of characters in the word
        for (int i = 0; i < words.length(); i++) {
            //add a underscore for each character in the word
            out += "_";
        }
        //return the string to be used
        return out;
    }

    //class to do actions for certain events that occur based on the user input
    private class goAction implements ActionListener {
        //when user inputs something perform these steps
        public void actionPerformed(ActionEvent e) {
            //if the user input is greater than 1 char
            if (input.getText().length() != 1) {
                //nothing will happen
                return;
            }
            //if the user input is incorrect
            if (!word.contains(input.getText())) {
                //add one error to the incorrect variable
                incorrect++;
            //if user input is correct
            } else {
                //build String so we can use the function of setCharAt
                StringBuilder userBuild = new StringBuilder(user);
                //change character at the specific index
                userBuild.setCharAt(word.indexOf(input.getText()), input.getText().charAt(0));
                //cast it into an original String
                user = userBuild.toString();
                //set the label
                output.setText(user);
                //reset the input
                input.setText("");
                //set the text blinker on
                input.grabFocus();
                //if you win
                if (user.equals(word)) {
                    //show a gui box of you won
                    JOptionPane.showMessageDialog(null, "You won!");
                    //close and stop the program
                    System.exit(0);
                }
            }
            //if you run out of lives.
            if (incorrect == 8) {
                //show a gui box of you lose
                JOptionPane.showMessageDialog(null, "You lose! Haha!");
                //close and stop the program
                System.exit(0);
            }
        }
    }
}

