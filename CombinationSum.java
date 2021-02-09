// Time Complexity : Not sure  Seems(> 2^n)
// Space Complexity : Not sure 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No 

// Code :
class Solution {
    List<List<Integer>> result;
    int targetSum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        targetSum = target;
        backtrack(candidates,0,0,new ArrayList<>());
        return result;
    }
    
   public void backtrack(int[] candidates, int index, int sum, List<Integer> path)
   {
       // base conditions
       
       // sum crosses targetSum
       if(sum > targetSum)
       {
           return;
       }
       
       // if sum is equal to the targetSum
       if(sum == targetSum)
       {
           result.add(new ArrayList<>(path));
           return;
       }
       
       for(int i=index;i<candidates.length;i++)
       {
           path.add(candidates[i]);
           backtrack(candidates,i,sum+candidates[i],path);
           path.remove(path.size()-1);
       }
   }
}