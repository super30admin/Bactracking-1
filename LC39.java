//Time Complexity : O(T/m + n)
//Space Complexity : O(T/m + n)

class Solution {
    
    List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result  = new ArrayList<>();
        
        helper(candidates,0,new ArrayList<>(),target);
        
        return result;
    }
    
    private void helper(int[] candidates,int index,List<Integer> path,int targetSum)
    {
        //base
        if(targetSum==0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        
        if(targetSum < 0 || index == candidates.length)
        {
            return;
        }
            
        
        //logic
        
        
        for(int i=index;i<candidates.length;i++)
        {   
            //action
            path.add(candidates[i]);
            
            //recurse
            helper(candidates,i,path,targetSum-candidates[i]);
            
            //backtrack
            path.remove(path.size()-1);
        }
        
        //return;
    }
}