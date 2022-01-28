// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);
        return result;
    }
    
    private void helper(int[] candidates, int index, List<Integer> path, int target){
        // base case

        // if target is reached, then add that path to the result list
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        // if target turns negative or index goes out of bound, then return
        if(target < 0 || index == candidates.length) return;
        
        // logic
        // choose
        
        // action
        path.add(candidates[index]);
        // recurse
        helper(candidates, index, path, target - candidates[index]);
        // backtrack
        path.remove(path.size() - 1);

        // not choose
        helper(candidates, index + 1, path, target);
    }
}