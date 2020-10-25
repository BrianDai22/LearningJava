import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mooyomooyo {
    public static int heightOfGrid = 0;
    public static int minCombo = 0;
    public static int[][] grid;
    public static int[][] colorSections;
    public static int[] colorSectionSizes = new int[1000];

    public static int[][] directions = new int[][]{
            {1,0}, {-1,0}, {0,1}, {0,-1}
    };


    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("mooyomooyo.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        heightOfGrid = Integer.parseInt(st.nextToken());
        minCombo = Integer.parseInt(st.nextToken());
        grid = new int[heightOfGrid+2][12];
        colorSections = new int[heightOfGrid+2][12];

        for(int i = 1; i <= heightOfGrid; i++) {
            String s = f.readLine();
            for(int j = 1; j <= 10; j++) {
                grid[i][j] = s.charAt(j-1) - '0';
            }
        }
        //System.out.println(Arrays.deepToString(grid));
        while(true) {
            clearColorSections(); //finished
            int sectionName = 0;
            for(int i = 1; i <= heightOfGrid; i++) {
                for(int j = 1; j <= 10; j++) {
                    if(grid[i][j] != 0 && colorSections[i][j] == 0) {
                        visit(i, j, grid[i][j], ++sectionName); //finished
                    }
                }
            }
            if(!deleteColorSection()) { //not finished
                break;
            }
            clearColorSectionSizes(sectionName); //finished
            gravity(); // not finished
        }

        for(int i = 1; i <= heightOfGrid; i++) {
            for(int j = 1; j <= 10; j++) {
                out.print(grid[i][j]);
            }
            out.println();
        }
        out.close();
    }

    public static void visit(int i, int j, int color, int colorSectionName) {
        if(colorSections[i][j] != 0) {
            return;
        }
        colorSections[i][j] = colorSectionName;
        colorSectionSizes[colorSectionName]++;
        for(int[] direction: directions) {
            int leftOrRight = i + direction[0];
            int leftOrRight2 = j + direction[1];
            if(grid[leftOrRight][leftOrRight2] == color) {
                visit(leftOrRight, leftOrRight2, color, colorSectionName);
            }
        }
    }

    public static void clearColorSections() {
        for(int i = 1; i <= heightOfGrid; i++) {
            for(int j = 1; j <= 10; j++) {
                colorSections[i][j] = 0;
            }
        }
    }

    public static void clearColorSectionSizes(int sectionName) {
        for(int i = 1; i <= sectionName; i++) {
            colorSectionSizes[i] = 0;
        }
    }

    public static boolean deleteColorSection() {
        boolean isGood = false;
        for(int i = 1; i <= heightOfGrid; i++) {
            for(int j = 1; j <= 10; j++) {
                if(colorSections[i][j] != 0 && colorSectionSizes[colorSections[i][j]] >= minCombo) {
                    grid[i][j] = 0;
                    isGood = true;
                }
            }
        }
        return isGood;
    }

    public static void gravity() {
        for(int i = heightOfGrid; i >= 1; i--) {
            for(int j = 10; j >= 1; j--) {
                boolean isGood = false;
                int bottom = heightOfGrid;
                if(grid[i][j] != 0) {
                    while(bottom > i) {
                        if(isGood) {
                            break;
                        }
                        if(grid[bottom][j] == 0) {
                            grid[bottom][j] = grid[i][j];
                            grid[i][j] = 0;
                            isGood = true;
                        }
                        bottom--;
                    }
                }
            }
        }
    }
}
