import java.util.*;

class Solution {
    // For loop based recursion Solution with backtracking
    // Time complexity is O(2^n) please let me know if this is correct
    // Space complexity is O(n) please let me know if this is correct
    // This solution is submitted on leetcode with zero errors
    private List<List<Integer>> result;
    private int len;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        //Edge case
        if(candidates == null || candidates.length == 0) return result;
        len = candidates.length;
        helper(candidates, target, 0 , new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int target, int idx, List<Integer> path){
        // Base case
        if(target<0) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //Logic
        for(int i = idx;i<len; i++){
            path.add(candidates[i]);
            helper(candidates, target-candidates[i], i, path);
            path.remove(path.size()-1);
        }
    }
}