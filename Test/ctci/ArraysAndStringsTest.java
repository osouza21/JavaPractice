package ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysAndStringsTest {
    @Test
    void isUnique() {
        String notUnique = "aabbcdef";
        String unique = "abcdef";

        boolean trueResult = ArraysAndStrings.isUnique(unique) == true;
        boolean falseResult = ArraysAndStrings.isUnique(notUnique) == false;

        assertTrue(trueResult && falseResult);
    }
}