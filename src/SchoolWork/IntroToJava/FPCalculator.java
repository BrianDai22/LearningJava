package SchoolWork.IntroToJava;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class FPCalculator
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter an equation with basic operations (+,-,/,*):");
        String str = scan.nextLine();
        System.out.println("Result: " + calculate(str));
    }

    //Method that calculates the equation entered
    public static int calculate(String s)
    {
        //remove whitespace from both ends of string
        String a = s.trim();
        a = a.replace("*", " ");
        a = a.replace("/", " ");
        a = a.replace("+", " ");
        a = a.replace("-", " ");
        a = a.replaceAll(" +", " ");
        //make a string array split on each space in the string make double digit and triple digit numbers easier
        String[] b = a.split(" ");
        //make queues to keep track of PEMDAS for calculator
        Queue<Integer> numbers1 = new LinkedList<>();
        Queue<Integer> numbers2 = new LinkedList<>();
        Queue<Character> operators1 = new LinkedList<>();
        Queue<Character> operators2 = new LinkedList<>();

        System.out.println(a);
        System.out.println(Arrays.toString(b));
        //add numbers in the array in order first in first out order
        for(int i = 0; i < b.length; i++)
        {
            numbers1.offer(Integer.parseInt(b[i]));
        }
        //add operators in the array in order first in first out order
        for(int i = 0; i < s.toCharArray().length; i++)
        {
            if(!Character.isDigit(s.toCharArray()[i]) && s.toCharArray()[i] != ' ')
            {
                operators1.offer(s.toCharArray()[i]);
            }
        }
        //take out the first number in the queue and store the value in a temp variable to act as the past num
        int temp = numbers1.poll();
        //while loop to run the first order of operations which is multiplication and division until no more
        while (!operators1.isEmpty())
        {
            //take out first operator in queue to use and store it in operator variable
            Character operator = operators1.poll();
            //if the operator is multiplication multiply past num with current num and store it into temp
            if (operator == '*')
            {
                temp *= numbers1.poll();
            }
            //if the the operator is division divide past num with current num and store it into temp
            else if (operator == '/')
            {
                temp /= numbers1.poll();
            }
            //if operator is not any of the ones above add number and operator into second queue for addition and subtraction
            else
            {
                numbers2.offer(temp);
                operators2.offer(operator);
                //update temp to be used in next loop until operators run out
                temp = numbers1.poll();
            }
        }

        //add the result of the multiplication and division above into the addition and subtraction queue
        numbers2.offer(temp);
        //make the final result variable
        int output = numbers2.poll();
        //while there are more addition and subtraction operators take out first operator in queue to use and store it in operator variable
        while (!operators2.isEmpty())
        {
            Character operator = operators2.poll();
            //if the the operator is addition add past num with current num and store it into temp
            if (operator == '+')
            {
                output += numbers2.poll();
            }
            //if the the operator is subtraction subtract past num with current num and store it into temp
            else if (operator == '-')
            {
                output -= numbers2.poll();
            }
        }
        //return final calculation
        return output;
    }
}

