package array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        printMajorityElement(new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4});
        printMajorityElement(new int[] {3, 3, 4, 2, 4, 4, 2, 4});
    }

    private static void printMajorityElement(int[] numbers) {
        Map<Integer, Integer> numberToCount = new HashMap<>();
        for(int num : numbers){
            int count = numberToCount.getOrDefault(num, 0) + 1;
            if(count > numbers.length / 2){
                System.out.println("Major Element : " + num);
                return;
            }
            numberToCount.put(num, count);
        }
        System.out.println("No Major Element");
    }
}
