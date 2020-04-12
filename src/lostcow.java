import java.io.*;
import java.util.StringTokenizer;

public class lostcow {
    /*
    Farmer John has lost his prize cow Bessie, and he needs to find her!
Fortunately, there is only one long path running across the farm, and Farmer John knows that Bessie has to be at some location on this path. If we think of the path as a number line, then Farmer John is currently at position x and Bessie is currently at position y (unknown to Farmer John). If Farmer John only knew where Bessie was located, he could walk directly to her, traveling a distance of |x−y|. Unfortunately, it is dark outside and Farmer John can't see anything. The only way he can find Bessie is to walk back and forth until he eventually reaches her position.
Trying to figure out the best strategy for walking back and forth in his search, Farmer John consults the computer science research literature and is somewhat amused to find that this exact problem has not only been studied by computer scientists in the past, but that it is actually called the "Lost Cow Problem" (this is actually true!).
The recommended solution for Farmer John to find Bessie is to move to position x+1, then reverse direction and move to position x−2, then to position x+4, and so on, in a "zig zag" pattern, each step moving twice as far from his initial starting position as before. As he has read during his study of algorithms for solving the lost cow problem, this approach guarantees that he will at worst travel 9 times the direct distance |x−y| between himself and Bessie before he finds her (this is also true, and the factor of 9 is actually the smallest such worst case guarantee any strategy can achieve).
Farmer John is curious to verify this result. Given x and y, please compute the total distance he will travel according to the zig-zag search strategy above until he finds Bessie.
INPUT FORMAT (file lostcow.in):
The single line of input contains two distinct space-separated integers x and y. Both are in the range 0…1,000.
OUTPUT FORMAT (file lostcow.out):
Print one line of output, containing the distance Farmer John will travel to reach Bessie.
SAMPLE INPUT:
3 6
SAMPLE OUTPUT:
9
Problem credits: Brian Dean - Open 2017
1. Main idea of the question (simplify in 1 - 2 sentence)
2. Conclude how the Input turn to Output (the process)
3. Range for Input (N or K or any range mentioned in question)
4. What are the mandatory requirements to pass
5. any edge case
6. pseudo code


1. Find the amount of steps farmer John needs to move to reach Bessie's location

2. Use the algorithm they gave you in the question from starting from 3 until you reach the number 6.

3. 0 - 1000

4. You need to give the minimum amount of steps farmer John needs to do to reach Bessie

5. I'm not sure

6.

get data

while loop(if count is not equal to bessie)
    count equals algorithm
    steps plus one
    if count equal to bessie
    then break

    algorithm


print steps
     */

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("lostcow.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int answer = 0;
        int direction = 1;
        int temp = 1;

        while (true) {
            if ((direction == 1 && x <= y && y <= x + temp) || (direction == -1 && y <= x && x - temp <= y)) {
                answer += Math.abs(x - y);
                out.println(answer);
                System.out.println(answer);
                break;
            } else {
                answer += temp * 2;
                temp *= 2;
                direction *= -1;
            }
        }
        out.close();

    }
}
