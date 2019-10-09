package array;

public class SpiralPrint2DMatrix {

    public static void main(String[] args) {
        printSpiral(new int[][]{{1,  2,  3,  4},
                                {5,  6,  7,  8},
                                {9,  10, 11, 12},
                                {13, 14, 15, 16}});
    }

    private static void printSpiral(int[][] numbers) {
        int i = 0; //starting row
        int j = numbers.length - 1; //ending column
        int k = numbers.length - 1; //ending row;
        int l = 0; //starting column
        while(i < k && l < j) {
            for(int index = l; index<= j; index++){
                System.out.print(numbers[i][index]);
            }
            i++;
            for(int index = i; index <= k; index++) {
                System.out.print(numbers[index][j]);
            }
            j--;
            for(int index = j; index >= l; index--){
                System.out.print(numbers[k][index]);
            }
            k--;
            for(int index = k; index >= i; index--){
                System.out.print(numbers[index][l]);
            }
            l++;
        }
    }
}
