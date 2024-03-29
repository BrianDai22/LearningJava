package SatAndWedClass20182020;

import java.util.Stack;

public class flatten {
    /*
    Given an string with number, "[" and "]", return its WednesdayClass.flatten string.
The rule is: k[string], where the string inside the [] is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid;
No extra white spaces, SatAndWedClass20182020.square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
For example, there won't be input like 3a or 2[4].
Examples:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     */

    // String, if str+= "abcd" ==> it create new space in memory and copy whole String to new space
    // StringBuilder: can modify the String in-place (more efficient)

    public int temp = 0;

    public String stringFlatten(String s) {
        StringBuilder sb = new StringBuilder(); // sb.append()   sb.toString()
        String repeat = "";  // store the repeat digital.

        for(int i = temp; i < s.length(); i++) {

            // read English letter
            if(s.charAt(i) != '[' && s.charAt(i) != ']' && !Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
            // read digit
            else if(Character.isDigit(s.charAt(i))){
                repeat += s.charAt(i);
            }
            // read '['
            else if(s.charAt(i) == '['){
                // 1. read inside string :  2 [ a 3 [ c ] ]  ==>      acccaccc
                // by calling self, it's like open a new page
                temp = i+1; // update start position to internal String
                String next = stringFlatten(s); // return result String inside bracket: return "accc"
                // 2. repeat the next string

                int howManyTimes = Integer.parseInt(repeat);
                for(int j = 0; j < howManyTimes; j++) {
                    sb.append(next);
                }
                // reset everything
                repeat = "";
                i = temp; // cross whole internal string, make i stop at ']'
            }
            // read ']'
            else if(s.charAt(i) == ']'){
                temp = i; // update temp stop at ']'
                return sb.toString();
            }
        }

        return sb.toString();
    }
/*
arr = ["dog", "cat", "bird"]
    0, 1, 2

   arr[i]

   arr[0]
   arr[1]
   arr[2]

   for(int i =0; i < arr.length; i++) {

   }

 */
    public String stringFlattenStack (String s ) {
        String answer = ""; // sb.append()   sb.toString()
        // we create 2 Stacks, each time we push String and repeat into Stack
        Stack<Integer> repeatStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int value = 0;

        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                value = value * 10 + s.charAt(i) - '0';
            }
            if(s.charAt(i) == '[') {
                repeatStack.push(value);
                stringStack.push(answer);
                answer = "";
                value = 0;
            }

            if(s.charAt(i) == ']') {
                String temp = answer;
                answer = stringStack.pop();
                for(int j = repeatStack.pop(); j > 0; j--) {
                    answer += temp;
                }
            }
            answer += s.charAt(i);
        }
        String answer2 = "";
        for(int i = 0; i < answer.length(); i++) {
            if(Character.isDigit(answer.charAt(i)) || answer.charAt(i) == '[' || answer.charAt(i) == ']') {
             continue;
            }
            answer2 += answer.charAt(i);
        }

        return answer2;
    }

    public static void main(String[] args) {
        String str = "3[a]2[c]"; //  accaccacc
        //System.out.println(new WednesdayClass.flatten().stringFlatten(str));
        System.out.println(new flatten().stringFlattenStack(str));
    }
}
