package Other;

import javax.swing.*;

public class assignment6 {
    public static void main(String[] args) {
        /*
        Write two different loops: a for loop and a
        while loop to print the following sequence of numbers:
        45, 36, 27, 18, 9, 0 –9, -18, -27, -36, -45.
         */

        //i = i + 1; == i++
        // i = i - 1 == i--
        // i-= or i+=


        /*
        //FOR LOOP
        int x = 45;
        for(int i = 45; i > -45; i-=9) {
            System.out.println(i);
        }

        //while(if) {}

        //WHILE LOOP
        int num = 45;

        while(num > -45) {
            System.out.println(num);
            num-=9;
        }

         */
        /*
        for(int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int y = 0;

        while(y < 10) {
            System.out.println(y);
            y++;
        }
         */


        /*
        Make a program which counts the number of vowels in a user-inputted message (always count Y for this scenario,
        and another hint is to use either toLowerCase() or toUpperCase() on a string to avoid case issues)
         */

        /*
        int counter = 0;
        s = s.toLowerCase();
        // hEllo
        // E == e
        // hello

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'a') {
                counter++;
            }
            if(c == 'e') {
                counter++;
            }
            if(c == 'i') {
                counter++;
            }
            if(c == 'o') {
                counter++;
            }
            if(c == 'u') {
                counter++;
            }
            if(c == 'y') {
                counter++;
            }
        }

        System.out.println(counter);
    }

         */
        /*
        Write a program that adds together the multiples of 3 and 5 up to a user-inputted max.
        (Ex: user inputs 10 and you return 33 (3+5+6+9+10)
         */
        String s = JOptionPane.showInputDialog("Give a max number");
        int n = Integer.parseInt(s);

        int multipleFive = 0;
        int multipleThree = 0;
        int temp = 0;

        while(multipleThree <= n) {
            temp += 3;
            multipleThree += temp;
        }

        temp = 0;

        while(multipleFive <= n) {
            temp += 5;
            multipleFive +=5;
        }

        int answer = multipleFive + multipleThree;
        System.out.println(answer);


    }
}
