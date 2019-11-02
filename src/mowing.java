import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mowing {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("mowing.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));

        int lines = Integer.parseInt(f.readLine());
        String[] directions = new String[lines];
        int[] directionNum = new int[lines];
        int totalTime = 0;
        int answer = 1000000000;
        for(int i = 0; i < lines; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            directions[i] = st.nextToken();
            directionNum[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < lines; i++) {
            totalTime += directionNum[i];
        }

        String[] newDirections = new String[totalTime];
        int index = 0;
        for(int i = 0; i < lines; i++) {
            if(directions[i].equals("N")) {
                for(int j = 0; j < directionNum[i]; j++) {
                    newDirections[index] = "N";
                    index++;
                }
            } else if(directions[i].equals("S")) {
                for(int j = 0; j < directionNum[i]; j++) {
                    newDirections[index] = "S";
                    index++;
                }
            } else if(directions[i].equals("E")) {
                for(int j = 0; j < directionNum[i]; j++) {
                    newDirections[index] = "E";
                    index++;
                }
            } else if(directions[i].equals("W")) {
                for(int j = 0; j < directionNum[i]; j++) {
                    newDirections[index] = "W";
                    index++;
                }
            }

        }

        //System.out.println(Arrays.toString(newDirections));

        int[][] mapData = new int[totalTime][4];

        int[] map = new int[4];
        map[0] = 0;
        map[1] = totalTime;
        map[2] = 0;
        map[3] = totalTime;

            for (int i = 0; i < totalTime; i++) {
                for (int j = 0; j < 1; j++) {
                    if (newDirections[i].equals("N")) {
                        if(map[1] < totalTime) {
                            map[1]++;
                        } else if(map[1] == totalTime) {
                            map[0]++;
                        }
                    }
                    if (newDirections[i].equals("S")) {
                        if(map[0] > 0) {
                            map[0]--;
                        } else if(map[0] == 0) {
                            map[1]--;
                        }
                    }
                    if (newDirections[i].equals("E")) {
                        if(map[3] < totalTime) {
                            map[3]++;
                        } else if(map[3] == totalTime) {
                            map[2]++;
                        }

                    }
                    if (newDirections[i].equals("W")) {
                        if(map[2] > 0) {
                            map[2]--;
                        } else if(map[2] == 0) {
                            map[3]--;
                        }
                    }

                }
                mapData[i][0] = map[0];
                mapData[i][1] = map[1];
                mapData[i][2] = map[2];
                mapData[i][3] = map[3];
            }

        //System.out.println(Arrays.deepToString(mapData));

        for(int i = 0; i < totalTime; i++) {
            for(int j = i + 1; j < totalTime; j++) {
                if(Arrays.equals(mapData[i],mapData[j])) {
                    answer = Math.min(answer,Math.abs(j-i));
                    //System.out.println(answer);
                }
            }
        }

        if(answer == 1000000000) {
            answer = -1;
        }


        out.println(answer);
        out.close();

    }
}
