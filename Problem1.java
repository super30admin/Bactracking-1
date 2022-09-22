import java.util.ArrayList;
import java.util.List;

// ## Problem1 
// Combination Sum (https://leetcode.com/problems/combination-sum/)

//for loop recursion solution
// time: O(2^(m*n))
// space: O(2^(m*n))
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null) return result;
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int pivot, int amount, List<Integer> path) {
        // base 
        if (amount == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (amount < 0) return;
        
        // logic
        for (int i = pivot; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, i, amount- candidates[i], path);
            path.remove(path.size()-1);
        }
        
        
    }
}