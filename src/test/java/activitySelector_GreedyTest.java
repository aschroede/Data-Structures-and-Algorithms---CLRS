import Algorithms.activitySelector_Greedy;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

class activitySelector_GreedyTest {

    @Test
    void Test1() {
        int[] start = new int[]{0, 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] finish = new int[]{0, 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        int [] storeResults = new int[start.length];
        //int[] results = Algorithms.activitySelector_Greedy.recursiveActivitySelector(start, finish, 0, start.length, storeResults, 0);
        int[] results = activitySelector_Greedy.greedyAcitivitySelector(start, finish);
        int[] solution1 = new int[]{1, 4, 8, 11, 0 ,0, 0, 0, 0, 0, 0, 0};
        int[] solution2 = new int[]{2, 4, 9, 11};
        assertThat(results, anyOf(is(solution1), is(solution2)));

    }
}