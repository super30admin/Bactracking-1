package backtracking1;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	//Time Complexity : O(2^(n)), where n is target
	//Space Complexity : O(n), for internal stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // null
        if(candidates == null || candidates.length == 0)
            return res;
        
        helper(candidates, target, res, 0, new ArrayList<>());
        return res;
    }
    
    private void helper(int[] candidates, int target, List<List<Integer>> res, int idx, List<Integer> path) {
        // null
        if(target <= 0) {
            if(target == 0)
                res.add(new ArrayList<>(path));
            return;
        }
        if(idx >= candidates.length)
            return;
        
        // logic
        for(int i=idx; i<candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], res, i, path);
            path.remove(path.size() - 1);
        }
    }
	
	//Time Complexity : O(2^(n)), where n is target
	//Space Complexity : O(n), for internal stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // null
        if(candidates == null || candidates.length == 0)
            return res;
        
        helper1(candidates, target, res, 0, new ArrayList<>());
        return res;
    }
    
    private void helper1(int[] candidates, int target, List<List<Integer>> res, int idx, List<Integer> path) {
        // null
        if(target <= 0) {
            if(target == 0)
                res.add(new ArrayList<>(path));
            return; 
        }
        
        if(idx >= candidates.length)
            return;
        
        // logic
        // choose
        path.add(candidates[idx]);
        helper1(candidates, target - candidates[idx], res, idx, path);
        path.remove(path.size() - 1);
        
        // don't choose
        helper1(candidates, target, res, idx + 1, path);
    }
}
