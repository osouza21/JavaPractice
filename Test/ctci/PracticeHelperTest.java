package ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PracticeHelperTest {
    @Test
    void sort() {
        String unsortedString = "cba";
        String sortedString = "abc";

        assertEquals(PracticeHelper.sort(unsortedString), sortedString);
    }
}