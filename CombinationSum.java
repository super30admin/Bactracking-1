// Time Complexity : Exponential
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : N

class Solution {
    
       List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
     
        
        int sum=0;
        
        if(candidates.length==0 || candidates==null) return result;
        
        backTrack(candidates,target,new ArrayList<>(),0,0);
        
        return result;
    }
    
    private void backTrack(int[] candidates, int target , List<Integer> temp ,int sum,int index)
    {
        if(sum==target)
        {
            result.add(new ArrayList<>(temp));
            return;
            
        }
        
        if(sum>target)
        {
            return;
        } 
        
        for(int i=index;i<candidates.length;i++)
        {
            temp.add(candidates[i]);
            backTrack(candidates,target,temp,sum+candidates[i],i);
            temp.remove(temp.size()-1);
            
            
        }    
    }    
}