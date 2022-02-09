import java.util.*;

// Time Complexity : O(2^n) where n is the size of the array.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class CombinationSum {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        helper(candidates, 0, new ArrayList(), target);
        return result;
    }

    private void helper(int[] candidates, int index, List<Integer> path, int target) {
        // base
        if (target == 0) {
            result.add(new ArrayList(path));
            return;
        }
        if (target < 0)
            return;
        // combinations
        for (int i = index; i < candidates.length; i++) {
            // action
            path.add(candidates[i]);
            // recurse
            helper(candidates, i, path, target - candidates[i]);
            // backtrack
            path.remove(path.size() - 1);
        }

    }
}
