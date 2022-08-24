// Time Complexity : O(2^n*m)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null) {
            return null;
        }
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int pivot, int amount, List<Integer> path) {
        // base
        if(amount < 0) return; 
        if(amount == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        // from pivot onwards we are running the solution
        for(int i = pivot; i < candidates.length; i++) {
            // action
            path.add(candidates[i]);
            // recurse
            helper(candidates, i, amount - candidates[i], path); 
            // backtrack
            path.remove(path.size() - 1);
        }
    }
}