// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

class Solution {
    List<List<Integer>> result;
    int targ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result=new ArrayList<>();
         targ=target;
        // recurse
        dfs_helper(candidates,new ArrayList<Integer>(),
                  0,0);
        
        return result;
    }
    
    private void dfs_helper(int[] candidates,List<Integer> tempList, int sum, int index)
    {
        // base case
        if(sum>targ)
            return;
        if(sum==targ)
        {    
            result.add(new ArrayList<>(tempList));
            return;
        }   
        //logic
        
        for(int i=index;i<candidates.length;i++)
        {
            // action
            tempList.add(candidates[i]);
            // recurse
            dfs_helper(candidates,tempList,sum+candidates[i],i);
            // backtrack
            tempList.remove(tempList.size()-1);
            
        }
    }
}