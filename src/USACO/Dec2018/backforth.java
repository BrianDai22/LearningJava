package USACO.Dec2018;

import java.io.*;
import java.util.*;

public class backforth {

    static Map<Integer,Integer> map1 = new HashMap<>();
    static Map<Integer,Integer> map2 = new HashMap<>();
    static Set<Integer> result = new HashSet<>();

    public static  Map<Integer,Integer> updateSendMap(Map<Integer,Integer> sendMap, int bucketSize) {
        Map<Integer,Integer> newMap = new HashMap<>(sendMap);
        int amountOfBucket = newMap.get(bucketSize)-1;
        if(amountOfBucket <= 0) {
            newMap.remove(bucketSize);
        } else {
            newMap.put(bucketSize,amountOfBucket);
        }
        return newMap;
    }

    public static  Map<Integer,Integer> updateRecieveMap(Map<Integer,Integer> recieveMap, int bucketSize) {
        Map<Integer,Integer> newMap = new HashMap<>(recieveMap);
        if(newMap.containsKey(bucketSize)) {
            newMap.put(bucketSize,newMap.get(bucketSize)+1);
        } else {
            newMap.put(bucketSize,1);
        }
        return newMap;
    }



    static void tuesday(int b1Milk, Map<Integer,Integer> bucket1, Map<Integer,Integer> bucket2) {
        for(int size: bucket1.keySet()) {
            int amount = b1Milk - size;
            Map<Integer,Integer> newBucket2 = updateRecieveMap(bucket2,size);
            Map<Integer,Integer> newBucket1 = updateSendMap(bucket1,size);
            wednesday(amount,newBucket1,newBucket2);
        }
    }

    static void wednesday(int b1Milk, Map<Integer,Integer> bucket1, Map<Integer,Integer> bucket2) {
        for(int size: bucket2.keySet()) {
            int amount = b1Milk + size;
            Map<Integer,Integer> newBucket1 = updateRecieveMap(bucket1,size);
            Map<Integer,Integer> newBucket2 = updateSendMap(bucket2,size);
            thursday(amount,newBucket1,newBucket2);
        }
    }
    static void thursday(int b1Milk, Map<Integer,Integer> bucket1, Map<Integer,Integer> bucket2) {
        for(int size: bucket1.keySet()) {
            int amount = b1Milk - size;
            Map<Integer,Integer> newBucket2 = updateRecieveMap(bucket2,size);
            friday(amount,newBucket2);
        }
    }

    static void friday(int b1Milk, Map<Integer,Integer> bucket2) {
        for(int size: bucket2.keySet()) {
            int amount = b1Milk + size;
            result.add(amount);
        }
    }

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("USACO.Dec2018.backforth.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("USACO.Dec2018.backforth.out")));

        StringTokenizer st;
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < 10; i++) {
            int size = Integer.parseInt(st.nextToken());
            if (map1.containsKey(size)) {
                map1.put(size,map1.get(size)+1);
            } else {
                map1.put(size,1);
            }
        }

        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < 10; i++) {
            int size = Integer.parseInt(st.nextToken());
            if (map2.containsKey(size)) {
                map2.put(size,map2.get(size)+1);
            } else {
                map2.put(size,1);
            }
        }

        tuesday(1000,map1,map2);
        System.out.println(result.size());
        out.println(result.size());
        out.close();
    }





}
