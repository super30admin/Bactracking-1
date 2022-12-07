
//tc is O(2^n)
//sc is O(n)
import java.util.*;

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0)
            return new ArrayList<>();

        result = new ArrayList<>();

        helper(candidates, target, 0, new ArrayList<>());
        return result;

    }

    private void helper(int[] candidates, int target, int index, List<Integer> path) {

        // base
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic

        for (int i = index; i < candidates.length; i++) {

            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);

            // backtrack step
            path.remove(path.size() - 1);
        }
    }
}