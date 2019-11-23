import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class measurement {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        int numCows = Integer.parseInt(f.readLine());
        int[] days = new int[numCows];
        String[] cows = new String[numCows];
        int[] addOrSubtract = new int[numCows];
        for (int i = 0; i < numCows; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            cows[i] = st.nextToken();
            addOrSubtract[i] = Integer.parseInt(st.nextToken());
        }


        int bessieMilk = 7;
        int elsieMilk = 7;
        int mildredMilk = 7;

        int bessieDays = 0;
        int elsieDays = 0;
        int mildredDays = 0;

        int overlap = 0;

        String[] trans = new String[100];

        boolean b = false;
        boolean m = false;
        boolean e = false;





        for (int i = 1; i <= 100; i++) {
            String empty = "";
            for (int j = 0; j < numCows; j++) {
                if (days[j] == i) {
                    if (cows[j].equals("Bessie")) {
                        bessieMilk += addOrSubtract[j];
                        //System.out.println(bessieMilk);
                    }
                    if (cows[j].equals("Elsie")) {
                        elsieMilk += addOrSubtract[j];
                        //System.out.println(elsieMilk);
                    }
                    if (cows[j].equals("Mildred")) {
                        mildredMilk += addOrSubtract[j];
                        //System.out.println(mildredMilk);
                    }


                    int max = Math.max(bessieMilk, Math.max(mildredMilk, elsieMilk));

                    if(max == bessieMilk) {

                        if(i == 1) {
                            b = true;
                        } else {
                            if(b) {
                                bessieDays += 0;
                            } else {
                                b = true;
                            }
                        }

                        empty += "b";

                        e = false;
                        m = false;
                    }

                    if(max == mildredMilk) {

                        if(i == 1) {
                            m = true;
                        } else {
                            if(m) {
                                mildredDays += 0;
                            } else {
                                m = true;
                            }
                        }

                        empty += "m";
                        b= false;
                        e = false;

                    }

                    if(max == elsieMilk) {

                        if(i == 1) {
                            e = true;
                        } else {
                            if(e) {
                            } else {
                                e = true;
                            }
                        }

                        empty += "e";
                        b= false;
                        m = false;
                    }
                   // System.out.println(b);
                   // System.out.println(m);
                   // System.out.println(e);

                }
                if(m) {
                    if (mildredMilk == bessieMilk ) {
                        empty+= "b";
                    }
                    if(mildredMilk == elsieMilk) {
                        empty += "e";
                    }
                }
                if(b) {
                    if(bessieMilk == mildredMilk) {
                        empty += "m";
                    }
                    if(bessieMilk == elsieMilk) {
                        empty += "e";
                    }
                }
                if(e) {
                    if(elsieMilk == mildredMilk) {
                        empty += "m";
                    }
                    if(elsieMilk == bessieMilk) {
                        empty += "b";
                    }
                }
            }

            trans[i] = emp




        }

        //System.out.println(mildredDays);
        //System.out.println(elsieDays);
        //System.out.println(bessieDays);
        //System.out.println(overlap);

        out.println(mildredDays+elsieDays+bessieDays-overlap);
        out.close();
    }
}
