import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    // Initialize your data structure here.


    public int calculate(String s) {
        Queue<Integer> numbers = new LinkedList<>();
        Queue<Character> operators = new LinkedList<>();

        char[] sToArray = s.toCharArray();
        for(int i = 0; i < sToArray.length; i++) {
            if(sToArray[i] == '+' || sToArray[i] == '-' || sToArray[i] == '/' || sToArray[i] == '*') {
                operators.add(sToArray[i]);
            } else {
                numbers.add(Character.getNumericValue(sToArray[i]));
            }
        }

        int temp = 0;
        while (temp < numbers.size()) {
            int integer1 = numbers.peek();
            numbers.poll();
            int integer2 = numbers.peek();
            char operator1 = operators.peek();
            operators.poll();
            if(operator1 == '*') {
                numbers.poll();
                numbers.add(integer1 * integer2);
            } else if(operator1 == '/') {
                numbers.poll();
                numbers.add(integer2/integer1);
            } else if(operator1 == '-') {
                numbers.add(integer1);
                operators.add(operator1);
            } else {
                numbers.add(integer1);
                operators.add(operator1);
            }
            temp++;
        }

        while(operators.contains('+') || operators.contains('-')) {
            int integer1 = numbers.peek();
            numbers.poll();
            int integer2 = numbers.peek();
            numbers.poll();
            int operator1 = operators.peek();
            operators.poll();
            if(operator1 == '+') {
                numbers.add(integer1 + integer2);
            } else {
                numbers.add(integer1 - integer2);
            }
        }


        //System.out.println(numbers);
        //System.out.println(operators);

        return numbers.peek();
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
