package tree;

import java.util.*;

class FindCycle {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       int[] indegree = new int[numCourses];
       int count = 0;
       Map<Integer, List<Integer>> deps = new HashMap<>();

       for(int[] pair : prerequisites) {
           List<Integer> dep = deps.getOrDefault(pair[1], new ArrayList<>());
           dep.add(pair[0]);
           deps.put(pair[1], dep);
           indegree[pair[0]]++;
       }
       Queue<Integer> queue = new LinkedList<>();
       for(int i = 0; i<indegree.length; i++) {
           if(indegree[i] == 0)
               queue.offer(i);
       }
       while (!queue.isEmpty()) {
           int no = queue.poll();
           count++;
           List<Integer> integers = deps.getOrDefault(no, Collections.emptyList());
           for(int ind : integers) {
               if(--indegree[ind] == 0)
                   queue.offer(ind);
           }
       }
       return numCourses == count;
    }


    public static void main(String[] args) {
        FindCycle solution = new FindCycle();
        System.out.println(solution.canFinish(2, new int[][]{{0, 1}}));
    }
}
