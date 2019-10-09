package array;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int [] reversed = reverseIt(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(Arrays.toString(reversed));
    }
    private static int[] reverseIt(int[] original){
        int i = 0;
        int j = original.length - 1;
        while(i < j){
            int temp = original[i];
            original[i] = original[j];
            original[j] = temp;
            i++;
            j--;
        }
        return original;
    }
}
