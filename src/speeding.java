import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class speeding {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("speeding.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] miles = new int[N];
        int[] speed = new int[N];

        int[] bMiles = new int[M];
        int[] bSpeed = new int[M];


        int[] allMiles = new int[100];
        int[] allBMiles = new int[100];

        int answer = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            miles[i] = Integer.parseInt(st2.nextToken());
            speed[i] = Integer.parseInt(st2.nextToken());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st3 = new StringTokenizer(f.readLine());
            bMiles[i] = Integer.parseInt(st3.nextToken());
            bSpeed[i] = Integer.parseInt(st3.nextToken());
        }
        /*
        for(int i = 0; i < miles.length; i++) {
            if(miles[i] - bMiles[i] == 0) {
                answer = Math.max(bSpeed[i] - speed[i], answer);
            } else if(miles[i] - bMiles[i] < 0)  {
                miles[i+1] += miles[i] - bMiles[i];
                if(bSpeed[i] > speed[i+1]) {
                    answer = Math.max(bSpeed[i] - speed[i+1], answer);
                }
            } else if(miles[i] - bMiles[i] > 0) {
                miles[i + 1] += miles[i] - bMiles[i];
                if(bSpeed[i] > speed[i]) {
                    answer = Math.max(bSpeed[i] - speed[i], answer);
                }
            }

        }
         */
        //for(int i = 0; i < miles[0]; i++) {
            //allMiles[i] = speed[0];
        //}

        int index = 0;
        int totalCount = 0;
        for(int i = 0; i < N; i++) {
            totalCount += miles[i];
            //System.out.println(totalCount);
            for(int j = index; j < totalCount; j++) {
                allMiles[j] = speed[i];
            }
            index = totalCount;
        }

        //System.out.println(Arrays.toString(allMiles));

        totalCount = 0;
        index = 0;
        for(int i = 0; i < M; i++) {
            totalCount += bMiles[i];
            for(int j = index; j < totalCount; j++) {
                allBMiles[j] = bSpeed[i];
            }
            index = totalCount;
        }

        //System.out.println(Arrays.toString(allBMiles));

        for(int i = 0; i < 100; i++) {
            answer = Math.max(allBMiles[i] - allMiles[i], answer);
        }
        /*
        System.out.println(Arrays.toString(speed));
        System.out.println(Arrays.toString(miles));
        System.out.println(Arrays.toString(bMiles));
        System.out.println(Arrays.toString(bSpeed));

         */

        out.println(answer);
        out.close();
    }
}

/*
        StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] speedLimits = new int[100];
		int currentMile = 0;

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(f.readLine());
			int lengthOfSegment = Integer.parseInt(st.nextToken());
			int speedLimit = Integer.parseInt(st.nextToken());
			for(int j = 0; j < lengthOfSegment; j++) {
				speedLimits[currentMile] = speedLimit;
				currentMile++;
			}
		}

		int[] travelSpeed = new int[100];
		currentMile = 0;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(f.readLine());
			int lengthOfSegment = Integer.parseInt(st.nextToken());
			int speedLimit = Integer.parseInt(st.nextToken());
			for(int j = 0; j < lengthOfSegment; j++) {
				travelSpeed[currentMile] = speedLimit;
				currentMile++;
			}
		}

		int maxOver = 0;
		for(int i = 0; i < 100; i++) {
			int amountExceeded = travelSpeed[i] - speedLimits[i];
			if(amountExceeded > maxOver) {
				maxOver = amountExceeded;
			}
		}
 */