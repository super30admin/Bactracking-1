// Recursion approach
//Time Complexity : O(n^m) // n: elements in the array    m: number of levels in the recursion
//Space Complexity : O(m)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

// Backtracking approach
//Time Complexity : O(n^m) // n: elements in the array    m: number of levels in the recursion
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;
import java.util.ArrayList;
import java.util.List;

class Combination_Sum_39 {
	// Recursion approach
//	List<List<Integer>> result = new ArrayList<>();
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//    	
//    	if(candidates == null || candidates.length == 0)
//    		return result;
//    	recurseHelper(candidates, target, new ArrayList<>(), 0, 0);
//    	return result;
//    }
//    private void recurseHelper(int[] candidates, int target, List<Integer> temp, int sum, int index)
//    {
//    	// Base
//    	if(sum > target || index >= candidates.length)
//    		return;
//    	if(sum == target)
//    	{
//    		result.add(temp);
//    		return;
//    	}
//    	// Logic
//    	// Do not choose
//    	recurseHelper(candidates, target, new ArrayList<>(temp), sum, index+1);
//    	
//    	// Choose
//    	temp.add(candidates[index]);
//    	recurseHelper(candidates, target, new ArrayList<>(temp), sum + candidates[index], index);
//    }
	
	// Backtracking approach
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)
            return result;
       backtrackHelper(candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }
    private void backtrackHelper(int[] candidates, int target, List<Integer> tempList, int sum, int index)
    {
        // Base
        if(sum > target)
            return;
        if(sum == target)
        {
            result.add(new ArrayList<>(tempList));
            return;
        }
        // Logic
        for(int i = index; i < candidates.length; i++)
        {
            //System.out.println(candidates[i]);
            // Action
            tempList.add(candidates[i]);
            //System.out.println(tempList);
            // Recurse
            backtrackHelper(candidates, target, tempList, sum + candidates[i], i);
            
            // Backtrack
            tempList.remove(tempList.size() - 1);
        }
        
    }
}
