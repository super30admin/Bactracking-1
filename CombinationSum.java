/**
Given an array of distinct integers candidates and a target integer target, 
return a list of all unique combinations of candidates where the chosen numbers sum to target. 
You may return the combinations in any order.


The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Collabedit: http://collabedit.com/4v4ck

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]

Time Complexity : O(N)
Space Complexity : O(N) considering
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class Solution 
{
    private List<List<Integer>> output;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        output = new ArrayList<>();
        backTrack( candidates, 0, target, new ArrayList<>());
        
        return output;
    }
    
    private void backTrack(int candidates[], int index, int targetSum, List<Integer> currentList)
    {
        if( index >=candidates.length || targetSum < 0 )
            return;
            
        if( targetSum == 0 )
        {
            output.add( new ArrayList<>(currentList));
            return;
        }
        
        currentList.add(candidates[index]);
        // choose ith index 
        backTrack( candidates, index, targetSum - candidates[index], currentList);
            
        currentList.remove( currentList.size() -1);
        
        backTrack( candidates, index + 1, targetSum , currentList);
        
    }
}