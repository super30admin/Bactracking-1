# BackTracking-1

## Problem1 
Combination Sum (https://leetcode.com/problems/combination-sum/)

Approach#1: Recursion:
// Time Complexity : Exponential
// Space Complexity : Exponential
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
       if(candidates.length==0 || candidates==null) return result;
        helper(candidates,0, new ArrayList<>(),target);
        return result;
        
        
    }
    private void helper(int[] candidates, int index, List<Integer> path, int target){
        //base
        if(index==candidates.length || target<0) return;
        if(target==0){
            result.add(path);
            return;  
        } 
        //dont choose
        helper(candidates, index+1, new ArrayList(path), target);
        //choose
        path.add(candidates[index]);
        helper(candidates, index, new ArrayList(path), target-candidates[index]);

    }
}


Approach#2: BackTracking:
// Time Complexity : O()
// Space Complexity : O()
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
       if(candidates.length==0 || candidates==null) return result;
        helper(candidates,0, new ArrayList<>(),target);
        return result;
        
        
    }
    private void helper(int[] candidates, int index, List<Integer> path, int target){
        //base
        if(index==candidates.length || target<0) return;
        if(target==0){
            result.add(new ArrayList<>(path));
            return;  
        } 
        //dont choose
        helper(candidates, index+1, path, target);
        //choose
        
        //action
        path.add(candidates[index]);
        //recurse
        helper(candidates, index, path, target-candidates[index]);
        //backtrack
        path.remove(path.size()-1);
    }
}