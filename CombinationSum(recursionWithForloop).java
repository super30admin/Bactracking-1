// Time Complexity : O(n2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yeah finding Time Complexity, can you please explain me


// Your code here along with comments explaining your approach

// using recursion with four loop( on each recursive call pass the same path as the input) but add path as new arraylist in resultList



class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)
            return result;
        
        helper(candidates, target,0,new ArrayList<Integer>());
        return result;
    }
    private void helper(int[] candidates, int runningSum, int index , List<Integer> path)
    {   
        //base
        if(index == candidates.length || runningSum < 0)
            return;
        if(runningSum == 0)
        {  
            result.add(path);
            return;
        }
    

        for(int i = index;i< candidates.length; i++)
        {
            List<Integer> ls = new ArrayList<>(path);
            ls.add(candidates[i]);
            helper(candidates,runningSum -candidates[i] ,  i, ls);
        }
        
       
        
    }
}