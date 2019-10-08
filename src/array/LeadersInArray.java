package array;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    //Leader - x[i] is a leader if it is greater that all elements to its right. Rightmost if always a leader
    public static void main(String[] args) {
        findLeaders(new int[]{16, 17, 4, 3, 5, 2});
    }

    private static void findLeaders(int[] candidates) {
        List<Integer> leaders = new ArrayList<>();
        int currentLeader = candidates[0];
        for (int i = 1; i<candidates.length - 1; i++) {
            if(candidates[i] > currentLeader){
                leaders.add(candidates[i]);
                currentLeader = candidates[i + 1];
                i++;
            }
        }
        leaders.add(candidates[candidates.length - 1]);
        System.out.println(leaders);
    }
}
