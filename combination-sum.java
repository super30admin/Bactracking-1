
//tc is O(2^n)
//sc is O(n)
import java.util.*;

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<>();

        result = new ArrayList<>();

        helper(candidates, 0, target, new ArrayList<>());
        return result;

    }

    private void helper(int[] candidates, int index, int amount, List<Integer> path) {

        // base
        if (index == candidates.length || amount < 0) {
            return;
        }

        if (amount == 0) {
            // we do this new arraylist here to ensure that the same empty path is not aded
            // to the result (otherwise an empty list will be added)
            result.add(new ArrayList<>(path));
            return;
        }

        // recurse

        // do not choose case
        helper(candidates, index + 1, amount, path);

        // choose case

        // action for choose case
        path.add(candidates[index]);
        helper(candidates, index, amount - candidates[index], path);

        // for backtracking we undo the action we have taken
        path.remove(path.size() - 1);

    }
}