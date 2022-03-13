// Time Complexity : O(n^target) where n is length of candidates arr
// Space Complexity : O(n) where n is length of candidates arr
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class Solution {
    
    private List<List<Integer>> ans;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        ans = new ArrayList<>();
        
        comboSum(candidates, 0, target, new ArrayList<>());
        
        return ans;
    }
    
    private void comboSum(int[] candidates, int index, int target, List<Integer> path) {
        
        // base case
        if (target < 0 || index == candidates.length) {
            return;
        }
        
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        // choose index
        path.add(candidates[index]);
        
        // recurse
        comboSum(candidates, index, target-candidates[index], path);
        
        // backtrack
        path.remove(path.size()-1);
        
        // not choosing index
        comboSum(candidates, index+1, target, path);
    }
}