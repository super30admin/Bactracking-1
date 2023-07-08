import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int pivot, int target, List<Integer> path) {
        // base case
        // if(pivot >= candidates.length || target<0) return;
        if (target < 0)
            return;

        if (target == 0) {
            // result.add((path));
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        for (int i = pivot; i < candidates.length; i++) {
            // action - recurse - backtrack
            path.add(candidates[i]);
            // helper(candidates, idx, target- candidates[idx], new ArrayList<>(path));
            helper(candidates, i, target - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();

        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;

        // Call the combinationSum method and print the result
        List<List<Integer>> result = combinationSum.combinationSum(candidates, target);
        System.out.println("Combinations for target " + target + ": " + result);
    }
}