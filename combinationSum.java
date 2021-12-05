// Time Complexity : O(2^n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer> > result = new ArrayList<>();
        helper(0, new ArrayList<>(), candidates, target, result);
        return result; 
    }
    
    private void helper(int index, List<Integer> path, int[] candidates, int target, List<List<Integer> > result) {
        if (index == candidates.length || target < 0) {
            return;
        }
        
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(i , path, candidates, target - candidates[i], result);
            path.remove(path.size() - 1);
        }
    }
}