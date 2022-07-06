/**
Time Complexity : Exponential
Space Complexity : O(D), D = depth of the recursive stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    
    List<List<Integer>> output;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        this.output = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0)
            return output;
        
        // call the helper method
        combinationSumHelper(candidates, target, 0, new ArrayList<>());
        
        // return the output
        return this.output;
        
    }
    
    private void combinationSumHelper(int[] candidates, int target, int index, List<Integer> currentPath)
    {
        
        if(index == candidates.length || target < 0)
            return;
        
        if(target == 0)
        {
            // add currentPath to the output and return
            this.output.add(new ArrayList<>(currentPath));
            return;
        }
        
        // logic
        for(int i= index; i<candidates.length; i++)
        {
            // choose the currentElement in the solution
            currentPath.add(candidates[i]);
            
            // logic
            combinationSumHelper(candidates, target - candidates[i], i, currentPath);
            
            // backtrack step here, 
            currentPath.remove(currentPath.size() -1);
        }
    }
}