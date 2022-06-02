import java.util.*;

class Solution {
    // Recursion Solution with separate path passing since we do not add in non-choosen case in           //preorder manner
    // Time complexity is O(2^n)
    // Space complexity is O(2^n) Can you please tell if the space is correct
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
        // Adding only in choosing case and passing to choosen function
        List<Integer> choosenTemp = new ArrayList<>(path);
        choosenTemp.add(candidates[index]);
        //Not choose case
        helper(candidates, target, index+1, new ArrayList<>(path));
        // Choose case
        helper(candidates, target-candidates[index], index, choosenTemp);
    }
}