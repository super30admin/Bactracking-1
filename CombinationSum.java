import java.util.ArrayList;
import java.util.List;
// Time Complexity : O(n^(target/minValue)); n = #elements
// Space Complexity : O(h); h = height of n-ry tree; h = target/minValue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, 0, target, new ArrayList<>());
        return res;
    }
    private void backtracking(int[] candidates, int index, int target, List<Integer> path) {
        if (target < 0)
            return;
        else if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtracking(candidates, i, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }
}
