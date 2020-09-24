// Time Complexity :O(N^N * N)
//O(N^N) for generating N nodes for each character in the recursion tree.
//O(N) for traversing the entire candidate.

// Space Complexity :O(M) 
//O(M) where M is the maximum no of possibilities of numbers a list can have. Which is (target/smallest no in the list)

// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
import java.util.*;
class CombinationSum {
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, new ArrayList<>());
        return output;

    }

    public void backtracking(int[] candidates, int target, int index, List<Integer> path) {
        if (target < 0)
            return;
        else if (target == 0) {
            output.add(new ArrayList<>(path));
            return;
        } else if (index >= candidates.length) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                path.add(candidates[i]);

                backtracking(candidates, target - candidates[i], i, path);

                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        CombinationSum obj = new CombinationSum();
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(obj.combinationSum(candidates, target));
    }
}
