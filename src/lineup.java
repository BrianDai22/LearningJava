import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class lineup {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("lineup.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        int numConditions = Integer.parseInt(f.readLine());
        String[] cowA = new String[numConditions];
        String[] cowB = new String[numConditions];
        List<List<String>> result = new ArrayList<>();
        List<List<String>> result2 = new ArrayList<>();
        for(int i = 0; i < numConditions; i++) {
            String[] twoCows = f.readLine().split(" must be milked beside ");
            cowA[i] = twoCows[0];
            cowB[i] = twoCows[1];
        }

        String[] allCows = new String[]{"Beatrice", "Sue","Belinda", "Bessie", "Betsy", "Blue", "Bella", "Buttercup"};
        Arrays.sort(allCows);
        permute(allCows,0,result);
        String cow1;
        String cow2;
        int indexOfCow1;
        int indexOfCow2;


            for(List x: result) {
                boolean found = true;
                for(int i = 0; i < cowA.length; i++) {
                    cow1 = cowA[i];
                    cow2 = cowB[i];
                    indexOfCow1 = x.indexOf(cow1);
                    indexOfCow2 = x.indexOf(cow2);
                    if(Math.abs(indexOfCow1 - indexOfCow2) != 1) {
                        found = false;
                        break;
                }

            }
                if(found) {
                    result2.add(x);
                }
        }
            /*
        Collections.sort(result2, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return 0;
            }
        });

             */
        result2 = result2.stream().sorted((o1,o2) -> {
            for (int i = 0; i < 8; i++) {
                int c = o1.get(i).compareTo(o2.get(i)); // c == 0, if equal,  c < 0, if o1 < o2, c > 0, if o1 > o2
                if (c != 0) {
                    return c;
                }
            }
            return 0; // return value not important, but return statement is required
        }).collect(Collectors.toList());


        for(String x: result2.get(0)){
            out.println(x);
        }
        out.close();

    }
    static void permute(String[] cows, int k, List<List<String>> result) {
        for(int i = k; i < cows.length; i++) {
            swap(cows, k, i);
            permute(cows, k +1,result);
            swap(cows,i,k);

        }
        if(k == cows.length-1) {
            ArrayList<String> temp = new ArrayList<>();
            for(String item : cows) {
                temp.add(item);
            }
            result.add(temp);
            //System.out.println(Arrays.toString(cows));
        }
    }

    static void swap(String[] cows, int k, int i) {
        String temp = cows[k];
        cows[k] = cows[i];
        cows[i] = temp;
    }
    
}
