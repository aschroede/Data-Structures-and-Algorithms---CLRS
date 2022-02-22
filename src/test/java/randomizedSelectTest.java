import Algorithms.randomizedSelect;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class randomizedSelectTest {

    @Test
    void Test1() {
        List<Integer> list = Arrays.asList(2,5, 7, 3, 8,4,3);

        int i = randomizedSelect.randomizedSelect(list, 0, list.size()-1, 7);
        assertEquals(8, i);
    }

    @Test
    void Test2() {
        List<Integer> list = Arrays.asList(0,0,0,0,0);

        int i = randomizedSelect.randomizedSelect(list, 0, list.size()-1, 3);
        assertEquals(0, i);
    }
}