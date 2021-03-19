package Other;

import java.util.*;

public class TheSafe3 {
    public static void main(String args[]) {
        TheSafe3 safe = new TheSafe3();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter safe password: ");
        String password = scanner.next();
        scanner.close();

        if (safe.checkPassword(password)) {
            System.out.println("Access granted.");
        }
        else {
            System.out.println("Access denied!");
        }
    }

    public boolean checkPassword(String password) {
        char[] passChars = password.toCharArray();
        String encryptedString = "";

        for (int i = 0; i < passChars.length; i++) {
            encryptedString += "0x" + Integer.toHexString(passChars[i] + i);
            //System.out.println(encryptedString);
            if (i != passChars.length - 1) {
                encryptedString += " ";
            }
        }

        return encryptedString.equals("0x67 0x6f 0x75 0x46 0x58 0x4b 0x81 0x74 0x77 0x7b 0x6f 0x6a 0x71 0x7b 0x71 0x81 0x89 " +
                "0x81 0x86 0x7c 0x83 0x83 0x75 0x7e 0x80 0x4c 0x64 0x8d 0x5d 0x73 0x71 0x9c");
    }
}
