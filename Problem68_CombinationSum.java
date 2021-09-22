import java.util.*;
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<Integer>());
        return result;
    }
    public void helper(int[] candidates, int target, int pivot, List<Integer> path) {
        // base case
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || pivot == candidates.length)
            return;
        
        // logic
        // don't choose
        helper(candidates, target, pivot + 1, path);
        // choose
        path.add(candidates[pivot]);
        helper(candidates, target - candidates[pivot], pivot, path);
        path.remove(path.size() - 1);
    }
}