import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class maximumSubarrayTest {

    @Test
    @DisplayName("Initial random test")
    void randomTest() {
        int[] A = new int[] {1, -20, 3, 4, 5, 5, -10};
        assertArrayEquals(new int[] {2, 5, 17}, maximumSubarray.findMaximumSubarray(A, 0, A.length-1));
    }

    @Test
    void arrayLengthOne() {
        int[] A = new int[] {10};
        assertArrayEquals(new int[] {0, 0, 10}, maximumSubarray.findMaximumSubarray(A, 0, A.length-1));
    }
}