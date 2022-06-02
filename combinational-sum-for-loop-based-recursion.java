import java.util.*;

class Solution {
    // For loop based recursion Solution
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
    private void helper(int[] candidates, int target, int idx, List<Integer> path){
        // Base case
        if(target<0) return;
        if(target == 0){
            result.add(path);
            return;
        }
        //Logic
        for(int i = idx;i<len; i++){
            List<Integer> temp = new ArrayList<>(path);
            temp.add(candidates[i]);
            helper(candidates, target-candidates[i], i, temp);
        }
    }
}