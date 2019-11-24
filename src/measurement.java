import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class measurement {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        int measurements = Integer.parseInt(f.readLine());
        HashMap<Integer,Integer> notes = new HashMap<Integer, Integer>();
        int[] cows = new int[measurements];
        int[] changes = new int[measurements];



        for(int i = 0; i < measurements; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int date = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int change = Integer.parseInt(st.nextToken());
            int cowId = 9999999;

            switch (name) {
                case "Bessie":
                    cowId = 0;
                    break;
                case "Mildred":
                    cowId = 1;
                    break;
                case "Elsie":
                    cowId = 2;
                    break;
            }

            notes.put(date,i);
            cows[i] = cowId;
            changes[i] = change;
        }

        Integer[] days = notes.keySet().toArray(new Integer[measurements]);
        Arrays.sort(days);
        int daysAdjust = 0;
        int[] milk = new int[]{7,7,7};
        int[] onDisplayBoard = new int[]{1,1,1};
        int lastDisplayBoard = onDisplayBoard[0] + onDisplayBoard[1] * 10+ onDisplayBoard[2] * 100;

        for(int day : days) {
            int noteId = notes.get(day);
            int cowId = cows[noteId];
            milk[cowId] += changes[noteId];
            int maxMilk = Math.max(Math.max(milk[0],milk[1]),milk[2]);
            for(int i = 0; i < 3; i++) {
                if(milk[i] == maxMilk) {
                    onDisplayBoard[i] = 1;
                } else {
                    onDisplayBoard[i] = 0;
                }
            }
            int nextDisplayBoard = onDisplayBoard[0] + onDisplayBoard[1] * 10+ onDisplayBoard[2] * 100;
            if(lastDisplayBoard != nextDisplayBoard) {
                daysAdjust++;
            }
            lastDisplayBoard = nextDisplayBoard;
        }

        System.out.println(notes);



        out.println(daysAdjust);
        out.close();

    }
}

        /*
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

            trans[i] = empty;




        }

        //System.out.println(mildredDays);
        //System.out.println(elsieDays);
        //System.out.println(bessieDays);
        //System.out.println(overlap);

        out.println(mildredDays+elsieDays+bessieDays-overlap);
        out.close();

         */


