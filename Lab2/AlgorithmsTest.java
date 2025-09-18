package Lab2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmsTest {
    @Test
    public void testInsertionSort() {
        int[] arr = {5, 2, 9, 1};
        Algorithms.insertionSort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 9}, arr);
    }

    @Test
    public void testMergeSort() {
        int[] arr = {5, 2, 9, 1};
        Algorithms.mergeSort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{1, 2, 5, 9}, arr);
    }

    @Test
    public void testBinarySearch() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(2, Algorithms.binarySearch(arr, 0, arr.length - 1, 3));
        assertEquals(-1, Algorithms.binarySearch(arr, 0, arr.length - 1, 6));
    }

    @Test
    public void testFindMax() {
        int[] arr = {3, 9, 2, 7, 5};
        assertEquals(9, Algorithms.findMax(arr, 0, arr.length - 1));
    }
}