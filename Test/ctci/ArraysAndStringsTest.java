package ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysAndStringsTest {
    @Test
    void palindromePermutation() {
        String permutation = "Tact Coa";
        String notPermutation = "Bact Coa";

        boolean trueResult = ArraysAndStrings.palindromePermutation(permutation) == true;
        boolean falseResult = ArraysAndStrings.palindromePermutation(notPermutation) == false;

        assertTrue(trueResult && falseResult);
    }

    @Test
    void urlify() {
        String originalString = "Mr John Smith    ";
        int trueLegnth = 13;
        String expectedOutput = "Mr%20John%20Smith";

        assertEquals(ArraysAndStrings.urlify(originalString.toCharArray(), 13), expectedOutput);
    }

    @Test
    void isPermutation() {
        String permutation1 = "abc";
        String permutation2 = "cba";
        String permutation3 = "cbb";

        boolean trueResult = ArraysAndStrings.isPermutation(permutation1, permutation2) == true;
        boolean falseResult = ArraysAndStrings.isPermutation(permutation1, permutation3) == false;

        assertTrue(trueResult && falseResult);
    }

    @Test
    void isUnique() {
        String notUnique = "aabbcdef";
        String unique = "abcdef";

        boolean trueResult = ArraysAndStrings.isUnique(unique) == true;
        boolean falseResult = ArraysAndStrings.isUnique(notUnique) == false;

        assertTrue(trueResult && falseResult);
    }
}