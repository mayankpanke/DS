package array;

public class MissingNumber {
    public static void main(String[] args) {
        int missing = findMissing(new int[]{1, 2, 4, 6, 3, 7, 8});
        System.out.println(missing);
    }

    private static int findMissing(int[] numbers) {
        int sum = (numbers.length + 1) * (numbers.length + 2) / 2;
        for(int num : numbers) {
            sum -= num;
        }
        return sum;
    }
}
