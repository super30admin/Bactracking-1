import java.util.LinkedList;
import java.util.Queue;

// Time Complexity : O(2 power m*n) where m = number of nodes, n = given target
// Space Complexity : O(2 power m*n) where m = number of nodes, n = given target
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//733. Combination Sum (Medium) - https://leetcode.com/problems/combination-sum/submissions/
class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	// Time Complexity : O(2 power n*k), Space Complexity : O(2 power n * k times n*n)
        result = new ArrayList<>();
        
        if (candidates == null || candidates.length == 0) return result;
        
        helper(candidates, 0, target, new ArrayList<>());
        
        return result;
    }
    
//    private void helper(int[] candidates, int index, int amount, List<Integer> path) {
//        // base
//        if (index == candidates.length || amount < 0) return;
//        
//        if (amount == 0) {
//            result.add(path);
//            return;
//        }
//        
//        
//        // logic
//        // not choose
//        helper(candidates, index + 1, amount, new ArrayList<>(path));
//        
//        // choose
//        path.add(candidates[index]);
//        helper(candidates, index, amount - candidates[index], new ArrayList<>(path));
//    }
    
    // backtracking solution
//    private void helper(int[] candidates, int index, int amount, List<Integer> path) {
//        // base
//        if (index == candidates.length || amount < 0) return;
//        
//        if (amount == 0) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//        
//        
//        // logic
//        // not choose
//        helper(candidates, index + 1, amount, path);
//        
//        // action
//        path.add(candidates[index]);
//        
//        // recurse
//        helper(candidates, index, amount - candidates[index], path);
//        
//        // backtrack
//        path.remove(path.size()-1);
//    }
    
    private void helper(int[] candidates, int pivot, int amount, List<Integer> path) {
        // base
        if (amount < 0) return;
        
        if (amount == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        // logic
        for (int i = pivot; i < candidates.length; i++) {
            // action
            path.add(candidates[i]);
            
            // recurse
            helper(candidates, i, amount- candidates[i], path);
            
            // backtrack
            path.remove(path.size()-1);
        }
    }
}