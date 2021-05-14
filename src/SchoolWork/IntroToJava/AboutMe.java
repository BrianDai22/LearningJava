package SchoolWork.IntroToJava;

//Author: Brian Dai
//A program to tell you about me.

//import to allow the use of different api's
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//creation of a public class which extends JPanel as stated in the direction of the project sheet
public class AboutMe extends JPanel {
    //initialization of variables
    private JLabel jLABELS;
    private JButton jbName, jbAge, jbSubject, jbFavoriteHobbies, jbWheredoILive;
    //create different color variables to be used to color the text and buttons for the GUI
    private final Color lightBlue = new Color(147, 214, 214);
    private final Color violetPurple = new Color(102, 50, 255);
    private final Color darkYellow = new Color(233, 163, 38);
    private final Color lightYellow = new Color(255, 226, 17);
    private final Color grayishBlack = new Color(74, 72, 42);

    //make an AboutMe constructor
    public AboutMe() {
        //the size of the GUI pop up will be 1280x720 a 16:9 ratio that most monitors should support
        this.setPreferredSize(new Dimension(1280, 720));
        //create the first JButton which when clicked displays my name
        jbName = new JButton("My name is");
        //add colors to the button
        jbName.setForeground(lightBlue);
        jbName.setBackground(violetPurple);
        //add an ActionListner to the button so when clicked it will do something
        jbName.addActionListener(new Action());
        //create another JButton which when clicked displays my age and an image
        jbAge = new JButton("My age is");
        //add colors to the button
        jbAge.setForeground(violetPurple);
        jbAge.setBackground(darkYellow);
        //add an ActionListner to the button so when clicked it will do something
        jbAge.addActionListener(new Action());
        //create another JButton which when clicked displays my favorite subject
        jbSubject = new JButton("My favorite subject is");
        //add colors to the button
        jbSubject.setForeground(darkYellow);
        jbSubject.setBackground(lightYellow);
        //add an ActionListner to the button so when clicked it will do something
        jbSubject.addActionListener(new Action());
        //create another JButton which clicked Displays my favorite hobby
        jbFavoriteHobbies = new JButton("My favorite hobby is");
        //add colors to the button
        jbFavoriteHobbies.setForeground(lightYellow);
        jbFavoriteHobbies.setBackground(grayishBlack);
        //add an ActionListner to the button so when clicked it will do something
        jbFavoriteHobbies.addActionListener(new Action());
        //create the final JButton so when clicked it will display where I live
        jbWheredoILive = new JButton("I live in");
        //add colors to the button
        jbWheredoILive.setForeground(grayishBlack);
        jbWheredoILive.setBackground(lightBlue);
        //add an ActionListner to the button so when clicked it will do something
        jbWheredoILive.addActionListener(new Action());
        //create a place holder for when there is nothing to display in the answer box in the GUI so the user knows where to look
        jLABELS = new JLabel("---");
        //add all of the buttons and the blank spot for the answer into the GUI
        add(jbName);
        add(jbAge);
        add(jbSubject);
        add(jbFavoriteHobbies);
        add(jbWheredoILive);
        add(jLABELS);
    }

    //create an action class so the button are able to be clicked and present something
    private class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //if I pressed name
            if (e.getSource() == jbName) {
                //change the answer box into the correct answer
                jLABELS.setText("My name is Brian Dai");
                //don't set any icon
                jLABELS.setIcon(null);
                //make everything visible
                jLABELS.setVisible(true);
            }
            //if I pressed age
            if (e.getSource() == jbAge) {
                //change the answer box into the correct answer
                jLABELS.setText("My age is 15");
                //create an imageicon variable of the number 15 having the data of the png
                ImageIcon age = new ImageIcon("15.png");
                //set the icon that will be shown to the imageicon created above
                jLABELS.setIcon(age);
                //make everything visible
                jLABELS.setVisible(true);
            }
            //if I pressed subject
            if (e.getSource() == jbSubject) {
                //change the answer box into the correct answer
                jLABELS.setText("My favorite subject is programming");
                //don't set any icon
                jLABELS.setIcon(null);
                //make everything visible
                jLABELS.setVisible(true);
            }
            // if I pressed hobby
            if (e.getSource() == jbFavoriteHobbies) {
                //change the answer box into the correct answer
                jLABELS.setText("My favorite hobby is playing video games");
                //don't set any icon
                jLABELS.setIcon(null);
                //make everything visible
                jLABELS.setVisible(true);
            }
            // if I pressed WheredoILive
            if (e.getSource() == jbWheredoILive) {
                //change the answer box into the correct answer
                jLABELS.setText("I live in Great Neck, New York");
                //don't set any icon
                jLABELS.setIcon(null);
                //make everything visible
                jLABELS.setVisible(true);
            }
        }
    }
}
