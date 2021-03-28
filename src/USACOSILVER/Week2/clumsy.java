package USACOSILVER.Week2;

import java.io.*;

public class clumsy {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("clumsy.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clumsy.out")));
        String s = f.readLine();
        int depth = 0;
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
            }
            if(depth < 0) {
                answer++;
                depth += 2;
            }
        }
        answer += depth/2;
        out.println(answer);
        out.close();
    }
}
/*
in >> s;
    int depth = 0;
    int ans = 0;

    for (int i = 0; i < s.length(); i++)
    {
        if(s[i] == '(')
            depth++;
        else
            depth--;

        if(depth < 0)
        {
            ans++;
            depth += 2;
        }
    }
    ans += depth/2;
 */