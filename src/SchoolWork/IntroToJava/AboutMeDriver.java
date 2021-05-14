package SchoolWork.IntroToJava;

//Author: Brian Dai
//Driver to run AboutMe file

//import to include api's
import javax.swing.*;

//create public class so the AboutMe file can be used
public class AboutMeDriver {
    //create a main class to call the AboutMe file and display the GUI
    public static void main(String[] args) {
        //enable the GUI to show on depending on your system
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //make a JFrame variable to use the data from the AboutMe file for the GUI
        JFrame aboutMe = new JFrame("AboutMe");
        //add the data from the AboutMe file
        aboutMe.add(new AboutMe());
        //call .pack() to scale the buttons and text
        aboutMe.pack();
        //make the GUI visible and the data inside
        aboutMe.setVisible(true);
    }
}
