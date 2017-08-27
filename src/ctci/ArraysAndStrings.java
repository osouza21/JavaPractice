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

    /**
     * Write a method to replace all spaces in a string with '%20': You may assume that the string has sufficient space
     * at the end to hold the additional characters, and that you are given the "true" length of the string
     * @param str char array holding the word to urlify
     * @param trueLength the length of the string excluding the extra spaces
     * @return a string with the spaces replaced
     */
    public static String urlify(char[] str, int trueLength){
        int spaceCount = 0;
        int i = 0;
        int index = 0;

        for(i = 0; i < trueLength; i++){
            if(str[i] == ' ') spaceCount++;
        }

        index = trueLength + spaceCount * 2;
        for(i = trueLength - 1; i >= 0; i--){
            if(str[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index -= 1;
            }
        }

        return new String(str);
    }
}
