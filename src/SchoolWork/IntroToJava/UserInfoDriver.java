package SchoolWork.IntroToJava;/*
SchoolWork.IntroToJava.UserInfoDriver.Java
Author: Brian Dai
Driver class that will be used to run SchoolWork.IntroToJava.UserInfo
 */
import javax.swing.*; //import to use JOptionPane

public class UserInfoDriver { //creation of public class for SchoolWork.IntroToJava.UserInfoDriver
    public static void main(String[] args) { //main method to run SchoolWork.IntroToJava.UserInfo
        //create new object to be able to use the SchoolWork.IntroToJava.UserInfo class
        UserInfo input = new UserInfo();
        //create variable to hold user response for future choice to continue or not continue the program
        int yesOrNo = JOptionPane.YES_OPTION;
        //while loop that will stop if user says no to continue the program
        while(yesOrNo == JOptionPane.YES_OPTION) {
            //set name as user input
            input.setName(JOptionPane.showInputDialog(null, "Name"));
            //set address as user input
            input.setAddress(JOptionPane.showInputDialog(null, "Address"));
            //set username as user input
            input.setUsername(JOptionPane.showInputDialog(null, "Username"));
            //set password as user input and encrypt password
            input.encrypt(JOptionPane.showInputDialog(null, "Input Password"));
            //show user everything they entered and encrypted password
            JOptionPane.showMessageDialog(null, "Your name is " + input.getName() +"\n" + "Your address is " + input.getAddress() + "\n" + "Your username is " + input.getUsername()+ "\n" + "Your password is " + input.getEncrypted());
            //store and ask user if they want to try again with new inputs
            yesOrNo = JOptionPane.showConfirmDialog (null, "Do you want to try again?",null, JOptionPane.YES_NO_OPTION);
        }
    }
}
