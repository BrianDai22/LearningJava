package Other;

public class roblox3 {
    public static String compressWord(String word, int k) {
        // Write your code here
        while(true) {
            int length = word.length();
            for(int i = 0; i < length - k; i++) {
                String substringWord = word.substring(k);
                if(characterCheck(substringWord)) {
                    word = word.replace(word.substring(i,i+k), "");
                }
            }
            if(word.length() >= length) {
                break;
            }
        }
        return word;
    }

    public static boolean characterCheck(String substringWord) {
        for(int i = 0; i < substringWord.length(); i++) {
            if (substringWord.charAt(i) != substringWord.charAt(0))
                return false;
        }
        return true;
    }
}
