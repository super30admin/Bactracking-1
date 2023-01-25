// Approach 1: Recursion(Backtracking)
// Time Complexity : O(2^(m*n))
// Space Complexity : O(2^(m*n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// In the recursive solution, at each index, we can either choose or not choose that element
// If we don't choose just update index. If we choose, add element to current path and update remaining amount
// We return from the recursion when our target is less than or equal to 0
// Since we are using a reference to path variable, we must remember to backtrack or undo our action

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int idx, int target, ArrayList<Integer> path){
        if(target<0 || idx==candidates.length)
            return;
        if(target==0){
            ArrayList<Integer> res = new ArrayList<Integer>(path);
            result.add(res);
            return;
        }
        helper(candidates, idx+1, target, path);
        path.add(candidates[idx]);
        helper(candidates, idx, target - candidates[idx], path);
        path.remove(path.size()-1);
    }
}

// Approach 2: Recursion(for-loop based)
// Time Complexity : O(2^(m*n))
// Space Complexity : O(2^(m*n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Similar to Approach 1 but with for loop based recursion
// Choose scenario is through recursion and not choose is done using the for loop
// The index for the recursive call is not updated to i+1 since we can repeat elements

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int pivot, int target, ArrayList<Integer> path){
        if(target<0 || pivot==candidates.length)
            return;
        if(target==0){
            ArrayList<Integer> res = new ArrayList<Integer>(path);
            result.add(res);
            return;
        }
        for(int i=pivot;i<candidates.length;i++){
            path.add(candidates[i]);
            helper(candidates, i, target - candidates[i], path);
            path.remove(path.size()-1);
        }
    }
}