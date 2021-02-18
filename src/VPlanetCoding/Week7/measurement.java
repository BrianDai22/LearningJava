package VPlanetCoding.Week7;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class measurement {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("VPlanetCoding.Week7.measurement.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("VPlanetCoding.Week7.measurement.out")));

        int num = Integer.parseInt(f.readLine());
        int[] days = new int[num];
        String[] name = new String[num];
        int[] addOrSub = new int[num];

        int bessie = 7;
        int mildred = 7;
        int elsie = 7;

        boolean b = true;
        boolean m = true;
        boolean e = true;

        boolean b2;
        boolean e2;
        boolean m2;

        for(int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            name[i] = st.nextToken();
            addOrSub[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for(int i = 1; i <= 100; i++) {
            for(int j = 0; j < num; j++) {
                if(days[j] == i) {
                    if(name[j].equals("Bessie")) {
                        bessie += addOrSub[j];
                    }
                    if(name[j].equals("Mildred")) {
                        mildred += addOrSub[j];

                    }
                    if(name[j].equals("Elsie")) {
                        elsie += addOrSub[j];
                    }

                    //System.out.println(bessie);
                   // System.out.println(mildred);
                    //System.out.println(elsie);
                    System.out.println(days[j]);

                }
            }

            //finding highest milk maker

            int highest = Math.max(bessie,Math.max(mildred,elsie));

            //b2 equals the future sign change in order to compare present with future
            if(bessie == highest) {
                b2 = true;
            } else {
                b2 = false;
            }

            if(elsie == highest) {
                e2 = true;
            } else {
                e2 = false;
            }

            if(mildred == highest) {
                m2 = true;
            } else {
                m2 = false;
            }

            //check present check with future for changing of signs

            if(b != b2 || m != m2 || e != e2) {
                count++;
            }


            //turn future into present
            b = b2;
            e = e2;
            m = m2;

        }

        out.println(count);
        out.close();


    }
}

 /*
                    if(bessie == mildred && elsie != mildred) {
                        if (!m && !b) {
                            count++;
                            m = true;
                            b = true;

                        } else {
                            if (!m && b) {
                                count++;
                                m = true;
                            } else {
                                if (!b && m) {
                                    count++;
                                    b = true;
                                }
                            }
                            continue;

                        }
                    }

                    if(bessie == elsie && elsie != mildred) {
                        if (!b && !e) {
                            count++;
                            b = true;
                            e = true;
                        } else {
                            if (!b && e) {
                                count++;
                                b = true;
                            } else {
                                if (!e && b) {
                                    count++;
                                    e = true;
                                }
                            }
                            continue;

                        }
                    }
                    if(elsie == mildred && elsie != bessie) {
                        if(!m && e) {
                            count++;
                            m = true;
                        } else {
                            if(!e && m) {
                                count++;
                                e = true;
                            }
                        }
                        continue;

                    }

                     */




                    /*
                    if(bessie == mildred && bessie > elsie) {
                        if(b && m) {
                            count = count;
                        } else {
                            count++;
                            b = true;
                            m = true;
                        }
                    }

                    if(bessie == elsie && bessie > mildred) {
                        if(b && e) {
                            count = count;
                        } else {
                            count++;
                            b = true;
                            m = true;
                        }
                    }
                    if(elsie == mildred && bessie < elsie) {
                        if (e && m) {
                            count = count;
                        } else {
                            count++;
                            b = true;
                            m = true;
                        }
                    }

                    if(bessie > mildred && bessie > elsie && !b) {
                        count++;
                        b = true;
                        m = false;
                        e = false;
                    }
                    if(bessie < mildred && bessie < elsie && b) {
                        b = false;
                    }

                    if(bessie < mildred && mildred > elsie && !m) {
                        count++;
                        m = true;
                        b = false;
                        e = false;
                    }
                    if(bessie > mildred && mildred < elsie && m) {
                            m = false;
                    }


                    if(elsie > mildred && bessie < elsie && !e) {
                        count++;
                        e = true;
                        b = false;
                        m = false;
                    }
                    if(elsie < mildred && bessie > elsie && e) {
                        e = false;
                    }

                     */
