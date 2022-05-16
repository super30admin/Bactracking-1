import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n) n is length of candidates
// Space Complexity : O(n) recursion stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach: recursion + backtracking.

public class CombinationSum {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;
        helper(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (index == candidates.length || target < 0) {
            return;
        }

        // case 0
        helper(candidates, target, index + 1, path);

        // case 1
        // action
        path.add(candidates[index]);

        // recursion
        helper(candidates, target - candidates[index], index, path);

        // backtrack
        path.remove(path.size() - 1);

        // for (int i = index; i < candidates.length; i++) {
        // List<Integer> list = new ArrayList<>();
        // list.add(candidates[i]);
        // helper(candidates, target - candidates[i], i, list);
        // }
    }
}
