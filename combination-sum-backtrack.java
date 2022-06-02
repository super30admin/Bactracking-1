import java.util.*;

class Solution {
    // Backtracking Solution
    // Time complexity is O(2^n)
    // Space complexity is O(n)
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
    private void helper(int[] candidates, int target, int index, List<Integer> path){
        // Base case
        
        if(index>=len || target<0) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //Logic
        //Not choose case
        helper(candidates, target, index+1, path);
        // Action
        // Add only in choosen case
        path.add(candidates[index]);
        // Choose case
        helper(candidates, target-candidates[index], index, path);
        // Backtrack
        path.remove(path.size()-1);
    }
}