package Algorithms;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class mergeSortTest {

    @Test
    void Test1() {
        int[] originalList = new int[] {2, 4, 5, 7, 1, 2, 3, 6};
        int[] result = mergeSort.mergeSort(originalList, 0, originalList.length-1);
        Arrays.sort(originalList);
        Assert.assertArrayEquals(originalList, result);
    }

    @Test
    void Test2() {
        int[] originalList = new int[] {1, 4, 6, 2, 4, 9, 3, 6, -1};
        int[] result = mergeSort.mergeSort(originalList, 0, originalList.length-1);
        Arrays.sort(originalList);
        Assert.assertArrayEquals(originalList, result);
    }

    @Test
    void OneItem() {
        int[] originalList = new int[] {1};
        int[] result = mergeSort.mergeSort(originalList, 0, originalList.length-1);
        Arrays.sort(originalList);
        Assert.assertArrayEquals(originalList, result);
    }

    @Test
    void TwoItems() {
        int[] originalList = new int[] {2, 1};
        int[] result = mergeSort.mergeSort(originalList, 0, originalList.length-1);
        Arrays.sort(originalList);
        Assert.assertArrayEquals(originalList, result);
    }
}