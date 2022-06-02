import java.util.*;

class Solution {
    // Recursion Solution with adding path in choosen case in inorder manner
    // Time complexity is O(2^n)
    // Space complexity is O(2^n)
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
            result.add(path);
            return;
        }
        //Logic
        
        //Not choose case
        helper(candidates, target, index+1, new ArrayList<>(path));
        // Choose case
        // Add only in choose case
        path.add(candidates[index]);
        helper(candidates, target-candidates[index], index, new ArrayList<>(path));
    }
}