// Time Complexity :  O(2^N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class CombinationSum {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }

    private void helper(int[] candidates, int target, int idx, List<Integer> path, int sum) {
        if (sum > target)
            return;

        if (sum == target) {
            result.add(new ArrayList<>(path));
        } else {
            for (int i = idx; i < candidates.length; i++) {
                path.add(candidates[i]);
                helper(candidates, target, i, path, sum + candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }
}
