package array;

import java.util.Arrays;

public class FindInOrderedAndRotatedArray {
    public static void main(String[] args) {
        boolean found = find(new int[]{3, 4, 5, 1, 2}, 3);
        System.out.println(found);
    }

    private static boolean find(int[] ints, int number) {
        if(ints.length == 0){
            return false;
        }

        if(ints.length == 1){
            return ints[0] == number;
        }

        int middle = findMiddle(ints);

        if(ints[middle] == number){
            return true;
        }
        if(number < ints[middle]){
            return find(Arrays.copyOfRange(ints, 0, middle), number);
        } else{
            return find(Arrays.copyOfRange(ints, middle + 1, ints.length), number);
        }

    }

    private static int findMiddle(int[] ints) {
        for(int i = 0; i<ints.length - 1; i++){
            if(ints[i] > ints[i+1]){
                return i;
            }
        }
        return ints.length / 2;
    }
}
