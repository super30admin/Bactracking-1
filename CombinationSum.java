package Nov16;

import java.util.ArrayList;
import java.util.List;

class CombinationSum{
    
    /*
    Time Complexity: O(n^m) where n is no.of elements in candidates array and m is the no.of levels in the tree till target sum is achieved. (Note to self: Check class video for more understanding.)
    
    Space Complexity: O(height of tree) ~= O(m) till we find target sum m.
    
     Did this code successfully run on Leetcode : Yes
    
     Any problem you faced while coding this : No
    
     Approach: Backtracking
    
    */
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
            
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        
        backtrack(candidates, target, new ArrayList<>(), 0, 0);
        return result;
        
    }
    
    public void backtrack(int[] candidates, int target, List<Integer> innerLst, int sum, int index) {
        
        // base
        if (sum == target) {
            result.add(new ArrayList<>(innerLst));
            return;
        }
        if (sum > target || index >= candidates.length) {
            return;
        }
    
        for (int i = index; i < candidates.length; i++) {
            innerLst.add(candidates[i]);
            backtrack(candidates, target, innerLst, sum+candidates[i], i);
            innerLst.remove(innerLst.size()-1); 
        }
    }
}
