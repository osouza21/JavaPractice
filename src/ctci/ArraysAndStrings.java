package ctci;

public class ArraysAndStrings {

    /**
     * Implement an algorithm to determinee if a string has all unique characters. What if you cannot use additional
     * data structures?
     * @param str input String to check for uniqueness
     */
    public static boolean isUnique(String str){
        if(str.length() > 126)return false;

        boolean[] char_set = new boolean[126];
        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i) - 'a';
            if(char_set[index]){
                return false;
            }
            char_set[index] = true;
        }
        return true;
    }

    /**
     * Given two strings, write a method to decide if one is a permutation of the other.
     * @param s String to check for permutation
     * @param t String to check for permutation
     * @return true is t is a permutation of t
     */
    public static boolean isPermutation(String s, String t){
        if(s.length() != t.length()) return false;

        return PracticeHelper.sort(s).equals(PracticeHelper.sort(t));
    }
}
