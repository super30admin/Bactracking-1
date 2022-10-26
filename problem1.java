// Problem1 - https://leetcode.com/problems/combination-sum/

// Time Complexity : O(nm)
// Space Complexity : O(nm)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null) return result;
        
        helper(candidates,0,target,new ArrayList<>());
        return result;
    }
    
    public void helper(int[] candidates, int i, int amount,List<Integer> path){
        //base
        if(amount == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        if(amount<0 || i == candidates.length) return;
        
        //not choose
        helper(candidates, i + 1, amount,path);
        
        path.add(candidates[i]); 
        //logic
        //choose
        helper(candidates, i, amount - candidates[i],path);
        
        //backtracking
        path.remove(path.size()-1);
        
    }
}