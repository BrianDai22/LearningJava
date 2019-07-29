public class Reverse {
    public static String reverseString(String str) {
        String empty = "";
        for(int i = str.length()-1 ; i >= 0; i--) {
            empty += str.charAt(i);
        }
        return empty;
    }

    public static String reverseSentence(String str) {
        String str2 = reverseString(str);
        String empty = "";
        String[] str3Array = str2.split(" ");
        for(String s: str3Array) {
            s = reverseString(s);
            empty += s + " ";
        }
        String empty2 = empty.replace('.',' ') + ".";
        System.out.println(empty2.trim().replaceAll(" +", " "));
        return "";
    }
}
