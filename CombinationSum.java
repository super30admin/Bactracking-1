// Time Complexity : O(2^(m+n)) where m is the target and n is the number of candidates. 
// Space Complexity : O(2^n) where n is the number of candidates.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

import java.util.*;
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        
        helper(candidates, 0, target, new ArrayList<>());
        return res;
    }
    private void helper(int[] candidates, int idx, int target, List<Integer> path){
        //base
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int i=idx; i<candidates.length; i++){
            path.add(candidates[i]);
            helper(candidates, i, target - candidates[i], path);
            path.remove(path.size()-1);
        }
    }
}