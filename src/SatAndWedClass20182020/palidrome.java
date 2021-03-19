package SatAndWedClass20182020;

import javax.swing.*;
import java.util.Arrays;

public class palidrome {
    public static void main(String[] args) {
        String s = JOptionPane.showInputDialog("Enter a string to be checked");
        char[] sCharArray = s.toCharArray();
        char[] sCharArrayReverse = s.toCharArray();
        int length = sCharArray.length-1;

        for(int i = 0; i < length; i++) {
            char temp = sCharArrayReverse[i];
            sCharArrayReverse[i] = sCharArrayReverse[length];
            sCharArrayReverse[length] = temp;
            length--;
        }

        if(String.valueOf(sCharArray).equals(String.valueOf(sCharArrayReverse))) {
            JOptionPane.showMessageDialog(null,String.valueOf(sCharArray) + " IS A CONFIRMED PALINDROME");
        } else {
            JOptionPane.showMessageDialog(null,String.valueOf(sCharArray) + " IS NOT A CONFIRMED PALINDROME");
        }
    }
}
