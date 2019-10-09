package array;

public class MaxSumContagiousSubArray {
    public static void main(String[] args) {
        int sum = maxSum(new int[]{-2, -3, 4, -1, -2, 1, 5, -3});
        System.out.println("Max :: " + sum);
    }

    private static int maxSum(int [] arr){
        int maxSoFar = arr[0];
        int currentMax = arr[1];
        for(int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i],  currentMax + arr[i]);
            maxSoFar = Math.max(currentMax, maxSoFar);
        }
        return maxSoFar;
    }
}
