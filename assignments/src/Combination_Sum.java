import java.util.*;

public class Combination_Sum {

    // Approach: Backtracking using choose or don't choose as the logic
    // Time: O(N^((T/M) + 1)) where N = no. of candidates, T = target value, M = minimal value among candidates
    // Space: O(T/M)
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        helper(candidates, 0, new ArrayList(), target);
        return result;
    }

    private void helper(int[] candidates, int i, List<Integer> path, int target) {
        // base case
        if (target == 0) {
            result.add(new ArrayList(path));
            return;
        }

        if (target < 0 || i == candidates.length) return;

        // logic
        // don't choose
        helper(candidates, i+1, path, target);
        // choose
        // action
        path.add(candidates[i]);
        // recurse
        helper(candidates, i, path, target - candidates[i]);
        // backtrack
        path.remove(path.size() - 1);
    }
}