import java.util.ArrayList;

public class Reverse {
    public static String reverseString(String str) {

        String empty = "";

        for(int i = str.length()-1 ; i >= 0; i--) {
            empty += str.charAt(i);
        }
        return empty;
    }
}
