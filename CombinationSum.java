// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*

    Approach:

    It explores all possible combinations of numbers from the candidates array that
    sum up to the target, starting from an empty current combination and adding candidates
    while reducing the target sum.

    When the target becomes 0, a valid combination is found, so it's added to the result.
    To ensure distinct combinations, a copy of the current combination is added to the result.

    The code iterates through the candidates, recursively explores possibilities, and backtracks
    by removing the last candidate when needed, ensuring that it explores all valid combinations
    to find all solutions.


 */


import java.util.*;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Add a copy of the current combination to the result
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]); // Add the candidate to the current combination
                backtrack(candidates, target - candidates[i], i, current, result); // Recurse with reduced target
                current.remove(current.size() - 1); // Backtrack by removing the last added candidate
            }
        }
    }
}
