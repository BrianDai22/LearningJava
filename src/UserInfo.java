/*
UserInfo.java
Author: Brian Dai
Enables a user to register an account within a database and encrypt their password
 */
public class UserInfo { //creation of public class for UserInfo
    //initialize variables being used in the methods following
    private String encryptedString, name, address, username;

    public UserInfo() { //constructor for UserInfo
        //set each variable as empty string to be able to hold what the user is inputting
        //encryptedString variable to hold encrypted password throughout each method
        encryptedString = "";
        //name variable to hold user-inputted name
        name = "";
        //address variable to hold user-inputted address
        address = "";
        //username variable to hold user-inputted username
        username = "";
    }

    public String encrypt(String password) { //take each result from each method and apply the following method to the result
        //apply removeWhitespaceAndConvertToUpper to the user-inputted string
        String stepOne = removeWhitespaceAndConvertToUpper(password);
        //apply substitute to the result of removeWhitespaceAndConvertToUpper
        String stepTwo = substitute(stepOne);
        //apply swapHalfsForEncrypt to the result of substitute
        String stepThree = swapHalfsForEncrypt(stepTwo);
        //apply swapFirst2WithLast2 to the result of swapHalfsForEncrypt
        String stepFour = swapFirst2WithLast2(stepThree);
        //apply swapMiddleChars to the result of swapFirst2WithLast2
        String stepFive = swapMiddleChars(stepFour);
        //set the encrypted password using the setEncrypted method and return
        setEncrypted(stepFive);
        return stepFive;
    }

    public String removeWhitespaceAndConvertToUpper(String password) { //removes whitespace and converts password into all uppercase
        //gets rid of leading and trailing whitespace
        password = password.trim();
        //turns every string uppercase
        password = password.toUpperCase();
        //return modified password
        return password;
    }

    public String substitute(String password) { //replace each specific char with new char
        //replace A with @
        password = password.replace('A', '@');
        //replace E with =
        password = password.replace('E', '=');
        //replace I with !
        password = password.replace('I', '!');
        //replace J with ?
        password = password.replace('J', '?');
        //replace O with *
        password = password.replace('O', '*');
        //replace P with #
        password = password.replace('P', '#');
        //replace R with &
        password = password.replace('R', '&');
        //replace S with $
        password = password.replace('S', '$');
        //replace T with +
        password = password.replace('T', '+');
        //replace V with ^
        password = password.replace('V', '^');
        //replace X with %
        password = password.replace('X', '%');
        //replace  with _
        password = password.replace(' ', '_');
        //return modified password
        return password;
    }

    public String swapHalfsForEncrypt(String password) { //swap the halves of the password with each other e.g. 1 2 = 2 1
        //initialize variable to hold result
        String halfResult;
        //intialize variable to hold firstHalf substring
        String firstHalf;
        //intialize variable to hold secondHalf substring
        String secondHalf;

        //if length of password is even
        if (password.length() % 2 == 0) {
            //firstHalf equals the password from beginning to middle
            firstHalf = password.substring(0, password.length() / 2);
            //secondHalf equals the password from middle to end
            secondHalf = password.substring(password.length() / 2);
        } else { //if length of password is odd
            //firstHalf equals the password from beginning to middle plus one since it's odd
            firstHalf = password.substring(0, password.length() / 2 + 1);
            //secondHalf equals the password from middle plus one since it's odd to end
            secondHalf = password.substring((password.length() / 2 + 1));
        }
        //swap the halves and put result into halfResult to be stored and returned
        halfResult = secondHalf + firstHalf;
        //return modified password
        return halfResult;
    }

    public String swapFirst2WithLast2(String password) { //swap the position of first two characters in password with the position of last two characters in password
        //initialize variable to hold result of the swap
        String firstLastResult;
        //initialize variable to store the first two characters in the password
        String firstTwo = password.substring(0, 2);
        //initialize variable to store the characters in between the first two and last two characters of password
        String middle = password.substring(2, password.length() - 2);
        //initialize variable to store the last two characters in the password
        String secondTwo = password.substring(password.length() - 2);
        //swap the first two and last two character positions and store into firstLastResult
        firstLastResult = secondTwo + middle + firstTwo;
        //return modified password
        return firstLastResult;
    }

    public String swapMiddleChars(String password) { //swap middle chars positioning in password by taking four middle chars and swapping the first two and second two positions
        //initialize variable to hold result
        String middleCharsResult;
        //initialize variable to store front part of password
        String frontPart;
        //initialize variable to hold last part of password
        String lastPart;
        //initialize variable to store first part of the middle of password
        String firstMid;
        //initialize variable to hold second part of the middle of password
        String secondMid;
        //if length of password is even
        if (password.length() % 2 == 0) {
            //stores password from the beginning to the the middle of the string minus two positions
            frontPart = password.substring(0, password.length() / 2 - 2);
            //stores password from the middle plus two positions to the end of the string
            lastPart = password.substring(password.length() / 2 + 2);
            //stores the length divided by two and then subtract two positions which would give the first two characters in the middle
            firstMid = password.substring(password.length() / 2 - 2, password.length() / 2);
            //stores the length divided by two and then add two positions which would give the second two characters in the middle
            secondMid = password.substring(password.length() / 2, password.length() / 2 + 2);
        } else { //if length of password is odd
            //stores password from the beginning to the the middle of the string minus one position since odd
            frontPart = password.substring(0, password.length() / 2 - 1);
            //stores password from the middle plus three positions to the end of the string since odd
            lastPart = password.substring((password.length() / 2) + 3);
            //stores the length divided by two and then subtract one position and add one position which would give the first two characters in the middle since odd
            firstMid = password.substring(((password.length() / 2) - 1), (password.length() / 2) + 1);
            //stores the length divided by two and then add one positions and then add three positions which would give the second two characters in the middle since odd
            secondMid = password.substring((password.length() / 2) + 1, (password.length() / 2) + 3);
        }
        //swap middle chars in password and store into middleCharsResult
        middleCharsResult = frontPart + secondMid + firstMid + lastPart;
        //return modified password
        return middleCharsResult;
    }

    public void setEncrypted (String password) { //gets the encrypted password
        // store password into encryptedString
        encryptedString = password;
    }

    public String getEncrypted () { //returns the encrypted password
        //return encryptedString
        return encryptedString;
    }


    public void setName (String nameParameter) { //get name
        // store nameParameter into name
        name = nameParameter;
    }

    public String getName () { //return name
        //return name
        return name;
    }

    public void setAddress (String nameAddress) { //get address
        //store nameAddress into address
        address = nameAddress;
    }

    public String getAddress () { //return address
        //return address
        return address;
    }
    public void setUsername(String usernameParameter) { //get username
        //store usernameParameter into username
        username = usernameParameter;
    }
    public String getUsername() { //return username
        //return username
        return username;
    }
    public String toString () { //return data about an object of a class
        //return the object encryptedString
        return encryptedString;
    }
}
