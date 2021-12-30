import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class countingSortTest {

    @Test
    void Test1() {
        List<Integer> list = Arrays.asList(2,5, 7, 3, 8,4,3);
        List<Integer> sortedList = Arrays.asList(2, 3, 3, 4, 5 ,7, 8);
        List<Integer> B = new ArrayList<>(list.size());
        B = countingSort.countingSort(list, B, 8);
        assertIterableEquals(sortedList, B);

    }

//    @Test
//    void Test2() {
//        List<Integer> list = Arrays.asList(3,1,87,8);
//        List<Integer> sortedList = Arrays.asList(1,3,8,87);
//
//        MyQuickSort.myQuickSort(list, 0, list.size()-1);
//        assertIterableEquals(sortedList, list);
//
//    }
//
//    @Test
//    void Test3() {
//        List<Integer> list = Arrays.asList(0,0,0,0);
//        List<Integer> sortedList = Arrays.asList(0,0,0,0);
//
//        MyQuickSort.myQuickSort(list, 0, list.size()-1);
//        assertIterableEquals(sortedList, list);
//
//    }
//
//    @Test
//    void Test4() {
//        List<Integer> list = Arrays.asList(0,0,1,0);
//        List<Integer> sortedList = Arrays.asList(0,0,0,1);
//
//        MyQuickSort.myQuickSort(list, 0, list.size()-1);
//        assertIterableEquals(sortedList, list);
//
//    }
//
//    @Test
//    void Test5() {
//        List<Integer> list = Arrays.asList(2,5, 7, 23, 8, 87, 3, 2, 5, 7, 23, 8, 87, 3);
//        List<Integer> sortedList = Arrays.asList(2, 2, 3, 3, 5, 5, 7, 7, 8, 8, 23, 23, 87, 87);
//        MyQuickSort.myQuickSort(list, 0, list.size()-1);
//        assertIterableEquals(sortedList, list);
//
//    }
//
//    @Test
//    void Test6() {
//        List<Integer> list = Arrays.asList(2,5, 0, 7, -23, 8,87,3);
//        List<Integer> sortedList = Arrays.asList(-23, 0, 2, 3, 5, 7, 8, 87);
//        MyQuickSort.myQuickSort(list, 0, list.size()-1);
//        assertIterableEquals(sortedList, list);
//
//    }

}