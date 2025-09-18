package Lab2;
public class Algorithms {
    // Insertion Sort
    public static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int key = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }
    }

    // Merge Sort
    public static void mergeSort(int[] A, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(A, l, m);
            mergeSort(A, m + 1, r);
            merge(A, l, m, r);
        }
    }

    private static void merge(int[] A, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] L = new int[n1], R = new int[n2];
        System.arraycopy(A, l, L, 0, n1);
        System.arraycopy(A, m + 1, R, 0, n2);
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) A[k++] = L[i++];
            else A[k++] = R[j++];
        }
        while (i < n1) A[k++] = L[i++];
        while (j < n2) A[k++] = R[j++];
    }

    // Recursive Binary Search
    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return binarySearch(arr, low, mid - 1, target);
        else return binarySearch(arr, mid + 1, high, target);
    }

    // Divide & Conquer Max
    public static int findMax(int[] arr, int l, int r) {
        if (l == r) return arr[l];
        int mid = (l + r) / 2;
        int leftMax = findMax(arr, l, mid);
        int rightMax = findMax(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }
}
