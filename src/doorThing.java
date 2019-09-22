import java.sql.SQLOutput;
import java.util.Random;

public class doorThing {
    public static void main(String[] args) {
        Random generator = new Random();

        int win = 0;
        int lose = 0;
        for (int i = 0; i < 10000; i++) {
            int carDoor = generator.nextInt(3);
            int guess = generator.nextInt(3);
            if (carDoor == guess) {
                win++;
            } else {
                lose++;
            }

        }
        System.out.println(win + " " + lose);
        System.out.println(lose + " "+ win);
    }


}

