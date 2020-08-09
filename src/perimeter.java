import java.io.*;

public class perimeter {

    private static int row;
    private static int col;
    private static int biggestArea;
    private static int biggestPerimeter;
    private static char[][] gridCopy;

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));

        int N = Integer.parseInt(f.readLine());
        char[][] grid = new char[N + 2][N + 2];
        gridCopy = new char[N + 2][N + 2];

        row = grid.length;
        col = grid[0].length;

        for (int i = 0; i < N + 2; i++) {
            grid[i][0] = '.';
            grid[i][N + 1] = '.';
            grid[0][i] = '.';
            grid[N + 1][i] = '.';
            gridCopy[i][0] = '.';
            gridCopy[i][N + 1] = '.';
            gridCopy[0][i] = '.';
            gridCopy[N + 1][i] = '.';
        }

        for (int i = 1; i <= row - 2; i++) {
            String s = f.readLine();
            for (int j = 1; j <= col - 2; j++) {
                grid[i][j] = s.charAt(j - 1);
                gridCopy[i][j] = s.charAt(j - 1);
            }
        }
        //System.out.println(Arrays.deepToString(gridCopy));

        int answer1 = 0;
        int answer2 = 0;

        for (int i = 1; i <= row - 2; i++) {
            for (int j = 1; j <= col - 2; j++)
                if (grid[i][j] == '#') {
                    DFSMarking(grid, i, j);
                    answer1 = Math.max(biggestArea, answer1);
                    answer2 = Math.max(biggestPerimeter, answer2);
                    biggestPerimeter = 0;
                    biggestArea = 0;
                }
        }

        out.println(answer1 + " " + answer2);
        out.close();
    }

    private static void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '#') {
            return;
        }

        ++biggestArea;
        biggestPerimeter += 4 - numofneighbour(gridCopy, i, j);
        grid[i][j] = '.';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

    private static int numofneighbour(char[][] gridCopy, int i, int j) {
        int count = 0;

        if (gridCopy[i - 1][j] == '#') {
            count++;
        }

        if (gridCopy[i][j - 1] == '#') {
            count++;
        }

        if (gridCopy[i + 1][j] == '#') {
            count++;
        }

        if (gridCopy[i][j + 1] == '#') {
            count++;
        }

        return count;
    }
}
