package Other;

import java.text.DecimalFormat;
import java.util.Arrays;

public class testing1234 {
    public static void main(String[] args) {
        double area = Math.PI * Math.pow(12, 2);
        DecimalFormat fmt = new DecimalFormat("0.###");
        System.out.println(fmt.format(area));

    }
}
