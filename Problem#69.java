// Combination Sum

// Time Complexity : O((2^(n+k))/2), where k is the number of levels in the recursion tree
// Space Complexity : O(n*k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);
        return result;        
    }
    private void helper(int[] candidates, int pivot, List<Integer> path, int target){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || pivot == candidates.length)
            return;
        //logic
        for(int i = pivot; i < candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, i, path, target - candidates[i]);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}