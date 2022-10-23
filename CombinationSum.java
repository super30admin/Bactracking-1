// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * This is brute force recursion where we are creating a new path at every node in the recursion. 
 * Hence, it is not required to remove elements from the list when going back to a node
 */

import java.util.ArrayList;

public class CombinationSum {
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if(candidates.length == 0 || candidates == null)
        {
            return result;
        }
        
        helper(candidates,target,0,new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int target, int i, List<Integer> path)
    {
        //base
        if(i == candidates.length || target < 0)
            return;
        
        if(target == 0)
        {
            result.add(path);
            return; }
        //logic
        
        //no choose
        helper(candidates,target,i+1,new ArrayList<>(path));
        
        //choose
        path.add(candidates[i]);
        helper(candidates,target - candidates[i], i, new ArrayList<>(path));
    }
}


/*
 * Approach 2 - Backtracking 
 */

class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if(candidates.length == 0 || candidates == null)
        {
            return result;
        }
        
        helper(candidates,target,0,new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int target, int i, List<Integer> path)
    {
        //base
        if(i == candidates.length || target < 0)
            return;
        
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return; }
        
        //logic
        helper(candidates,target,i+1,path);
        //action
        path.add(candidates[i]);
        //recurse
        helper(candidates,target - candidates[i],i,path);
        //backtrack
        path.remove(path.size() - 1);
    }
}

/*
 * Approach 3 - For Loop Based recursion with Backtracking
 */
class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if(candidates.length == 0 || candidates == null)
        {
            return result;
        }
        
        helper(candidates,target,0,new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int target, int index, List<Integer> path)
    {
        //base
        if(target < 0)
            return;
        
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return; }
        
        //logic
        for(int i = index; i< candidates.length;i++)
        {
            path.add(candidates[i]);
            
            helper(candidates,target - candidates[i],i,path);
            
            path.remove(path.size() - 1);
        }
    }
}