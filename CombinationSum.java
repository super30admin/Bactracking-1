import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    // TC: O(N ^ T) where N is length of candidates and T is target
    // SC: O(T) where T is target
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] candidates, int target, List<Integer> curr, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (start == candidates.length || target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]);
            backtrack(res, candidates, target - candidates[i], curr, i);
            curr.remove(curr.size() - 1);
        }
    }
}
