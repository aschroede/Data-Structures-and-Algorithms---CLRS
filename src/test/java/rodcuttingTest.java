import org.junit.jupiter.api.Test;

class rodcuttingTest {

    @Test
    void Test1() {
        int [] list = {0, 1, 5, 8, 9, 10, 15, 17, 20, 24, 30, 34, 36, 23, 40, 44, 46, 48, 50, 51, 56, 68, 69, 71, 75,
        76, 78, 80, 86, 73, 88, 91, 92, 93, 96, 100};
        /* long startTime = System.nanoTime();
        int revenue1 = Algorithms.rodcutting.recursiveRodCut(list, 6);
        long endTime = System.nanoTime();
        System.out.format("Execution time: %.5f ms %n", (float)(endTime - startTime)/1000000);*/
        /*long startTime = System.nanoTime();
        int revenue2 = Algorithms.rodcutting.bottomUpCut(list, 34);
        long endTime = System.nanoTime();*/
        long startTime = System.nanoTime();
        //int revenue2 = rodcutting.memoizedRodCut(list, 34);
        long endTime = System.nanoTime();
        System.out.format("Execution time: %.5f ms %n", (float)(endTime - startTime)/1000000);
        //assertEquals(10, revenue2);
        //System.out.format("Revenue: " + revenue2 + "\n");

    }
}