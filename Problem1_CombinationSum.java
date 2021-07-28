// Time Complexity : exponential
// Space Complexity : O(n) recursive stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result=new ArrayList<List<Integer>>();
        
        if(candidates==null || candidates.length==0)
            return result;
        
        helper(candidates,target,0,new ArrayList<Integer>());
        
        return result;
    }
    /* recursion */
    /*
    private void helper(int[] candidates,int target,int index,List<Integer> path)
    {
        if(target==0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
            
        
        if(target<0 || index==candidates.length)
            return;
        
        //dont choose
         helper(candidates,target,index+1,path);
        //choose
        path.add(candidates[index]);
         helper(candidates,target-candidates[index],index,path);
        path.remove(path.size()-1);
    }
    */
    
    //backtra cking
     private void helper(int[] candidates,int target,int index,List<Integer> path)
    {
        if(target==0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
            
        
        if(target<0)
            return;
        
        for(int i=index;i<candidates.length;i++)
        {
             path.add(candidates[i]);
             helper(candidates,target-candidates[i],i,path);
             path.remove(path.size()-1);
        }
       
    }
}