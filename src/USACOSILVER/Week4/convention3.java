package USACOSILVER.Week4;

import java.io.*;
import java.util.*;

public class convention3 {

    public static class Cows {
        int arrivalTime;
        int timeTaken;
        int priority;

        Cows(int arrivalTime, int timeTaken, int priority) {
            this.arrivalTime = arrivalTime;
            this.timeTaken = timeTaken;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("VPlanetCoding.Week3.convention2.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("VPlanetCoding.Week3.convention2.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int numCows = Integer.parseInt(st.nextToken());
        Cows[] cowArray = new Cows[numCows];

        for(int i = 0; i < numCows; i++) {
            st = new StringTokenizer(f.readLine());
            int arrivalTime = Integer.parseInt(st.nextToken());
            int timeTaken = Integer.parseInt(st.nextToken());
            cowArray[i] = new Cows(arrivalTime, timeTaken, i);
        }

        Arrays.sort(cowArray, Comparator.comparingInt(o -> o.arrivalTime));

        int answer = 0;
        int currentFinished = cowArray[0].arrivalTime + cowArray[0].timeTaken;
        int nextIndexOfCow = 1;
        PriorityQueue<Cows> waiting = new PriorityQueue<>(Comparator.comparingInt(o -> o.priority));
        while(nextIndexOfCow < cowArray.length || !waiting.isEmpty()) {
            while (nextIndexOfCow < cowArray.length && cowArray[nextIndexOfCow].arrivalTime < currentFinished) {
                waiting.add(cowArray[nextIndexOfCow]);
                nextIndexOfCow++;
            }
            if(nextIndexOfCow < cowArray.length && waiting.isEmpty()) {
                currentFinished = cowArray[nextIndexOfCow].arrivalTime + cowArray[nextIndexOfCow].timeTaken;
                nextIndexOfCow++;
            }
            if(!waiting.isEmpty()) {
                Cows headOfQueue = waiting.poll();
                answer = Math.max(answer, currentFinished-headOfQueue.arrivalTime);
                currentFinished += headOfQueue.timeTaken;
            }
        }

        out.println(answer);
        out.close();
    }
}
/*
        int ans = 0;
int currentFinished = firstcow.arrivetime + firstcow.timetaken;
Int nextIndex = 1;
Queue<cow> waiting;
while(nextIndex < cows.length or waiting is not empty)  {
	while(nextIndex < cows.length and nextCow.arriveTime < currentFinished) {
		Add nextCow to waiting;
		nextIndex++;
	}
	if(nextIndex < cows.length and waiting is empty) {
		currentFinished = nextIndex.arriveTime + nextIndex.timeTaken;
		nextIndex++;
	}
if(waiting is not empty) (
	Remove head cow from queue;
	ans = max(ans, currentFinished-headCow.arrivalTime);
	currentFinished += headCow.timeTaken;
}
}
         */