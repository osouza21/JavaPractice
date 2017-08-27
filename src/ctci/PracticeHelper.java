package ctci;

public class PracticeHelper {

    /**
     * Sort the given string by char value
     * @param s String to sort
     * @return sorted string
     */
    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }
}
