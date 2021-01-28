// TC: O(2^N) -> N : candidates array length
// SC: O(N) -> N : candidates array length
// Did it run successfully on Leetcode? : Yes
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        if ( candidates == null || candidates.length == 0)
            return result;
        helper(candidates, target, 0, new ArrayList());
        return result;
    }
    private void helper(int[] candidates, int target, int pivotIndex, List<Integer> path) 
    {
        //base
        if ( pivotIndex == candidates.length || target < 0) return;
        if  (target == 0)
        { 
            result.add(new ArrayList(path));
            return;
        }  
        //logic
        for ( int i = pivotIndex; i < candidates.length; i++)
        {
            // action
            path.add(candidates[i]);
            // recursion
            helper(candidates, target - candidates[i], i , path);
            // backtrack
            path.remove(path.size()-1);
        }
        
    }
}

// TC: O(2^N) -> N : candidates array length
// SC: O(N^2) -> N : candidates array length
// Did it run successfully on Leetcode? : Yes
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        if ( candidates == null || candidates.length == 0)
            return result;
        helper(candidates, target, 0, new ArrayList());
        return result;
    }
    private void helper(int[] candidates, int target, int index, List<Integer> path) 
    {
        //base
        if ( index == candidates.length || target < 0) return;
        if  (target == 0)
        { 
            result.add(path);
            return;
        }  
        //logic
        //don't choose
         helper(candidates, target, index+1, new ArrayList(path));
         
        //choose
         path.add(candidates[index]);
         helper(candidates, target - candidates[index], index, new ArrayList(path));
        
        // if choose case is written before don't choose it will give wrong answer because  
        // path already has the added value, so dont choose case gives wrong ans. Create a new list and add  the element in that list
    }
}


