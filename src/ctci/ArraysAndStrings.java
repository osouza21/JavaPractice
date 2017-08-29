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

    /**
     * Given a string , write a function to check if it is a permutation of a palindrome.
     * @param str string to check for palindrom permutation
     * @return true if the string is a palindrome permutation
     */
    public static boolean palindromePermutation(String str){
        int[] table = buildCharFrequencyTable(str.toCharArray());
        return checkMaxOneOdd(table);
    }

    /**
     * check the table for number of odd values
     * @param table table to check for values
     * @return true if there is only one odd value in the array
     */
    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for(int count : table){
            if(count % 2 == 1){
                if(foundOdd){
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /**
     * build a table of how frequently a char is contained within a char array
     * @param chars the array of chars to count
     * @return an int array of the amount of each char is in the char array
     */
    private static int[] buildCharFrequencyTable(char[] chars) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1]; //assume english alphabet

        for(char c : chars){
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
            }
        }

        return table;
    }

    /**
     * Get the numeral value of a char
     * @param c char to get numeral value for
     * @return the integer value of the char
     */
    private static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if(a <= val && val <= z){
            return val - a;
        }
        return -1;
    }

    /**
     * There are three types of edits that can be performed on a string: insert a character, remove a character, or
     * replace a character. Given two strings, write a function to check if they are one edit away
     * @param first the first string to check against
     * @param second the second string to see if it is one edit away from the first
     * @return return true if the second string is one edit away frow the first
     */
    public static boolean oneAway(String first, String second){
        if(first.length() == second.length()){
            return oneEditReplace(first, second);
        } else if(first.length() + 1 == second.length()){
            return oneEditInsert(first, second);
        } else if(first.length() - 1 == second.length()){
            return oneEditInsert(second, first);
        } else {
            return false;
        }
    }

    /**
     * Check if the second string is one insert away from the first string
     * @param first string to check against
     * @param second string to insert too
     * @return true if the second string is one insert away from the first string
     */
    private static boolean oneEditInsert(String first, String second) {
        int index1 = 0;
        int index2 = 0;

        while(index2 < second.length() && index1 < first.length()){
            if(first.charAt(index1) != second.charAt(index2)){
                if(index1 != index2){
                    return false;
                }
                index2++;
            }
            index1++;
            index2++;
        }
        return true;
    }

    /**
     * Check if the second string is one char replacement away from the first string
     * @param first the string to check agaisnt
     * @param second the string to check if one char away from the first
     * @return true if the second string is one char replacement away from the first
     */
    private static boolean oneEditReplace(String first, String second) {
        boolean foundDifference = false;
        for(int i = 0; i < first.length(); i++){
            if (first.charAt(i) != second.charAt(i)) {
                if(foundDifference){
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }
}
