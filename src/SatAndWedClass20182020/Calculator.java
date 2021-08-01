package SatAndWedClass20182020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    public int calculate(String s) {
        //remove whitespace from both ends of string
        String a = s.trim();
        a = a.replace("*", " ");
        a = a.replace("/", " ");
        a = a.replace("+", " ");
        a = a.replace("-", " ");
        //make a string array split on each space in the string make double digit and triple digit numbers easier
        String[] b = a.split(" ");
        //make queues to keep track of PEMDAS for calculator
        Queue<Integer> numbers1 = new LinkedList<>();
        Queue<Integer> numbers2 = new LinkedList<>();
        Queue<Character> operators1 = new LinkedList<>();
        Queue<Character> operators2 = new LinkedList<>();

        //add numbers in the array in order first in first out order
        for(int i = 0; i < b.length; i++) {
            numbers1.offer(Integer.parseInt(b[i]));
        }
        //add operators in the array in order first in first out order
        for(int i = 0; i < s.toCharArray().length; i++) {
            if(!Character.isDigit(s.toCharArray()[i])) {
                operators1.offer(s.toCharArray()[i]);
            }
        }

        //take out the first number in the queue and store the value in a temp variable to act as the past num
        int temp = numbers1.poll();
        //while loop to run the first order of operations which is multiplication and division until no more
        while (!operators1.isEmpty()) {
            //take out first operator in queue to use and store it in operator variable
            Character operator = operators1.poll();
            //if the the operator is multiplication
            if (operator == '*') {
                //multiply past num with current num and store it into temp
                temp *= numbers1.poll();
            }
            //if the the operator is division
            else if (operator == '/') {
                //divide past num with current num and store it into temp
                temp /= numbers1.poll();
            }
            //if operator is not any of the ones above
            else {
                //add number and operator into second queue for addition and subtraction
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
        //while there are more addition and subtraction operators
        while (!operators2.isEmpty()) {
            //take out first operator in queue to use and store it in operator variable
            Character operator = operators2.poll();
            //if the the operator is addition
            if (operator == '+') {
                //add past num with current num and store it into temp
                output += numbers2.poll();
            }
            //if the the operator is subtraction
            else if (operator == '-') {
                //subtract past num with current num and store it into temp
                output -= numbers2.poll();
            }
        }
        //return final calculation
        return output;
    }
    public static void main(String[] args) {
        String str = "3+2*2/2";
        System.out.println(new Calculator().calculate(str));
    }
}


/*
    switch (sToArray[i]) {
                case '+':
                    numbers.push(numbers.pop() + numbers.pop());
                    break;
                case '-':
                    numbers.push(-numbers.pop() + numbers.pop());
                    break;
                case '/':
                    numbers.push(numbers.pop() / numbers.pop());
                    break;
                case '*':
                    numbers.push(numbers.pop() * numbers.pop());
                    break;
                default:
                    numbers.push(Character.getNumericValue(sToArray[i]));
            }
     */

/*
        Implement a basic calculator to evaluate a simple expression string.

        The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

        Example 1:

        Input: "3+2*2"
        Output: 7
        Example 2:

        Input: " 3/2 "
        Output: 1
        Example 3:

        Input: " 3+5 / 2 "
        Output: 5
        Note:

        You may assume that the given expression is always valid.
        Do not use the eval built-in library function.
*/
