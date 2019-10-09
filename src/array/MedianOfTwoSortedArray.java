package array;

import java.util.Arrays;

public class MedianOfTwoSortedArray {
    /*
     ar1[] = {1, 12, 15, 26, 38}
   ar2[] = {2, 13, 17, 30, 45}
     */
    public static void main(String[] args) {
        int median = findMedian(new int[]{1, 12, 15, 26, 38}, new int[]{2, 13, 17, 30, 45});
        System.out.println(median);
    }

    private static int findMedian(int[] a1, int[] a2) {
        if(a1.length == 2 && a2.length == 2){
            return (Math.max(a1[0], a2[0]) + Math.min(a1[1], a2[1])) / 2;
        }
        int mediana1 = a1.length / 2;
        int mediana2 = a2.length / 2;

        if(a1[mediana1] == a2[mediana2]){
            return a1[mediana1];
        }
        if(a1[mediana1] < a2[mediana2]){
            return findMedian(Arrays.copyOfRange(a1, mediana1, a1.length), Arrays.copyOfRange(a2, 0, mediana2 + 1));
        } else {
            return findMedian(Arrays.copyOfRange(a1, 0, mediana1 + 1), Arrays.copyOfRange(a2, mediana2, a2.length));
        }
    }
}
