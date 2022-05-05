// Time Complexity : O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Solution {
    
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int index, int sum, List<Integer> path) {
        //base case
        if(sum == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        if(sum < 0 || index == candidates.length) {
            return;
        }
        // logic
        // case 0: not picking up
        helper(candidates, index + 1, sum, path);
        
        // case 1: picking up
        // recurse
        path.add(candidates[index]);
        helper(candidates, index, sum - candidates[index], path);
        
        // backtrack
        path.remove(path.size() - 1);
    }
}