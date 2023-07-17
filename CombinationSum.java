// Time Complexity : O(2^(m+n))
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, result, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> result, int idx, List<Integer> path) {
        if (target < 0 || idx == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        // dont choose
        backtrack(candidates, target, result, idx + 1, path);
        path.add(candidates[idx]);
        // choose
        backtrack(candidates, target - candidates[idx], result, idx, path);
        path.remove(path.size() - 1);
    }
}
