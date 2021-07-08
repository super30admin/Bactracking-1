import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We perform recusrsion while maintianing the "path"
// At every recusrion we have option to choose and not choose.
// When we choose we take action and recurse and backtrack the path
// Finally when target == 0 we add it to our result else return from recursion.
class Solution1 {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        if (candidates == null || candidates.length == 0)
            return result;

        helper(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        // base
        if (target < 0 || index == candidates.length)
            return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic

        // 1. choose
        // action (adding to path)
        path.add(candidates[index]);
        // recursion
        helper(candidates, target - candidates[index], index, path);
        // backtracking (removing from path)
        path.remove(path.size() - 1);

        // 2. not choose
        helper(candidates, target, index + 1, path);

    }
}