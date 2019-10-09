package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairWithSumX {
    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 45, -10, 26, -8};
        printerForSum(a, 16);
    }

    private static void printerForSum(int[] a, int sum){
        Set<Integer> numbers = new HashSet<>();
        for(int num : a) {
            if(numbers.contains(sum - num)){
                System.out.println(Arrays.toString(new int[]{num, sum - num}));
                return;
            }
            numbers.add(num);
        }
    }
}
