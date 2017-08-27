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
}
