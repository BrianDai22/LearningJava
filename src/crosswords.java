import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class crosswords {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("crosswords.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crosswords.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //System.out.println(N);
        //System.out.println(M);

        char[][] rows = new char[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            String s = st2.nextToken();
            for (int j = 0; j < M; j++) {
                rows[i][j] = s.charAt(j);
            }
        }

        int clues = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (horizontal(i, j, rows) || vertical(i, j, rows)) {
                    clues++;
                }
            }
        }

        out.println(clues);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (horizontal(i, j, rows) || vertical(i, j, rows)) {
                    out.println((i + 1) + " " + (j + 1));
                }
            }
        }
        //System.out.println(Arrays.deepToString(rows));
        out.close();
    }

    public static boolean horizontal(int i, int j, char[][] rows) {
        if (rows[i][j] != '.') {
            return false;
        }
        //out of bounds
        if (j + 1 >= rows[i].length || j + 2 >= rows[i].length) {
            return false;
        }

        if (j == 0) {
            return rows[i][j + 1] == '.' && rows[i][j + 2] == '.';
        } else {
            if (rows[i][j - 1] != '.') {
                return rows[i][j + 1] == '.' && rows[i][j + 2] == '.';
            } else {
                return false;
            }
        }
    }

    public static boolean vertical(int i, int j, char[][] rows) {
        if (rows[i][j] != '.') {
            return false;
        }

        if (i + 1 >= rows.length || i + 2 >= rows.length) {
            return false;
        }

        if (i == 0) {
            return rows[i + 1][j] == '.' && rows[i + 2][j] == '.';
        } else {
            if (rows[i - 1][j] != '.') {
                return rows[i + 1][j] == '.' && rows[i + 2][j] == '.';
            } else {
                return false;
            }

        }
    }
}

